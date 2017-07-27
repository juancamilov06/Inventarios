package co.com.arrendamientosnutibara.main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import co.com.arrendamientosnutibara.async.RoutesOperations;
import co.com.arrendamientosnutibara.helpers.CustomTypeFaceSpan;
import co.com.arrendamientosnutibara.helpers.Utils;
import co.com.arrendamientosnutibara.interfaces.AsyncObjectResult;
import co.com.arrendamientosnutibara.interfaces.AsyncResult;
import co.com.arrendamientosnutibara.widgets.CenturyBoldButton;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Dialog loading;
    private NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loading = Utils.getLoadingDialog(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView) findViewById(R.id.nav_view);
        getMenuItems();

        findViewById(R.id.route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasActiveRoutes();
            }
        });
    }

    private void showSnackBar(String message){
        Snackbar.make(findViewById(R.id.activity_main)
                , message
                , Snackbar.LENGTH_SHORT).show();
    }

    private void hasActiveRoutes(){
        loading.show();
        RoutesOperations.getHasActiveRoutes(new AsyncResult() {
            @Override
            public void isSuccessful(boolean success) {
                loading.dismiss();
                if (success){
                    Intent intent = new Intent(MainActivity.this, RoutesActivity.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(MainActivity.this, findViewById(R.id.route_logo), "route");
                    startActivity(intent, options.toBundle());
                    return;
                }
                getPromptDialog().show();
            }
        }).execute();
    }

    private AlertDialog getPromptDialog(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.dialog_create_first_route, null);
        builder.setView(view);

        final AlertDialog dialog = builder.create();

        CenturyBoldButton acceptButton = view.findViewById(R.id.accept_button);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoutesOperations.createRoute(new AsyncObjectResult() {
                    @Override
                    public void isSuccessful(Object result) {
                        dialog.dismiss();
                        long id = (Long) result;
                        if (id != 0){
                            Intent intent = new Intent(MainActivity.this, CreateRouteActivity.class);
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(MainActivity.this, findViewById(R.id.route_logo), "route");
                            startActivity(intent, options.toBundle());
                            return;
                        }
                        showSnackBar("Error creando la ruta, intenta luego");
                    }
                }).execute();
            }
        });
        CenturyBoldButton cancelButton = view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        return dialog;
    }

    private void getMenuItems(){
        Menu menu = nav.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SubMenu subMenu = item.getSubMenu();
            if (subMenu != null && subMenu.size() > 0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }
            applyFontToMenuItem(item);
        }
    }

    private void applyFontToMenuItem(MenuItem item) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Century-Gothic.ttf");
        SpannableString menuText = new SpannableString(item.getTitle());
        menuText.setSpan(new CustomTypeFaceSpan("" , font), 0 , menuText.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        item.setTitle(menuText);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
