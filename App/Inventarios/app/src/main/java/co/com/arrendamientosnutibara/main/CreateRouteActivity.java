package co.com.arrendamientosnutibara.main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;

import java.util.List;

import co.com.arrendamientosnutibara.application.NutibaraApplication;
import co.com.arrendamientosnutibara.entities.Ownership;
import co.com.arrendamientosnutibara.entities.OwnershipDao;
import co.com.arrendamientosnutibara.helpers.Utils;
import co.com.arrendamientosnutibara.widgets.CenturyBoldButton;


public class CreateRouteActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbar;
    private OwnershipDao ownershipDao;
    private boolean visible = false;
    private ViewGroup container;
    private CenturyBoldButton currentRouteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_route);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ownershipDao = NutibaraApplication.getApplicationInstance().getDaoSession().getOwnershipDao();
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        container = (ViewGroup) findViewById(R.id.transitions_container);
        currentRouteButton = (CenturyBoldButton) findViewById(R.id.current_route_button);

        container.findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        container.findViewById(R.id.current_route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateRouteActivity.this, RouteActivity.class));
            }
        });
        changeTitleTypeface();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.route_logo).setTransitionName("route");
        }

    }

    private void changeTitleTypeface(){
        final Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/Century-Gothic-Bold.ttf");
        collapsingToolbar.setCollapsedTitleTypeface(tf);
        collapsingToolbar.setExpandedTitleTypeface(tf);
    }

    private void animateButton(){
        visible = true;
        TransitionManager.beginDelayedTransition(container, new Slide(Gravity.RIGHT));
        currentRouteButton.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
