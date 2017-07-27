package co.com.arrendamientosnutibara.main;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;

import org.json.JSONException;
import org.json.JSONObject;

import co.com.arrendamientosnutibara.application.NutibaraApplication;
import co.com.arrendamientosnutibara.entities.Ownership;
import co.com.arrendamientosnutibara.entities.OwnershipDao;
import co.com.arrendamientosnutibara.helpers.Utils;
import co.com.arrendamientosnutibara.widgets.CenturyBoldButton;
import co.com.arrendamientosnutibara.widgets.CenturyRegularEditText;
import co.com.arrendamientosnutibara.widgets.CenturyRegularTextView;


public class CreateRouteActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbar;
    private Context context;
    private OwnershipDao ownershipDao;
    private ViewGroup container;
    private CenturyRegularEditText codeInput;
    private CenturyBoldButton currentRouteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_route);

        context = CreateRouteActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ownershipDao = NutibaraApplication.getApplicationInstance().getDaoSession().getOwnershipDao();
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        container = (ViewGroup) findViewById(R.id.transitions_container);
        currentRouteButton = (CenturyBoldButton) findViewById(R.id.current_route_button);
        codeInput = (CenturyRegularEditText) findViewById(R.id.code_input);

        container.findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = codeInput.getText().toString();
                if(TextUtils.isEmpty(code)){
                    showSnackBar("Debes ingresar el codigo de propiedad");
                }
                AndroidNetworking.get("http://192.168.0.25:4567/ownership/{code}?token=" + Utils.getAuthToken())
                        .addPathParameter("code", code)
                        .setPriority(Priority.IMMEDIATE)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    int code = response.getInt("code");
                                    boolean success = response.getBoolean("success");
                                    boolean exists = response.optBoolean("exists");
                                    if (code == 200 && success){
                                        handleResponse(response.getJSONObject("ownership"));
                                        return;
                                    }
                                    if (code == 200 && !success && !exists){
                                        showSnackBar("El inmueble no existe");
                                        return;
                                    }
                                    if (code == 400){
                                        showSnackBar("Desautenticado");
                                        return;
                                    }
                                    showSnackBar("Error de autenticacion");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void onError(ANError anError) {
                                System.out.println("ERROR: " + anError.getErrorBody());
                            }
                        });
            }
        });
        container.findViewById(R.id.current_route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateRouteActivity.this, CurrentRouteActiviy.class));
            }
        });
        changeTitleTypeface();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.route_logo).setTransitionName("route");
        }

    }

    private void handleResponse(JSONObject response){
        Gson gson = new Gson();
        Ownership ownership = gson.fromJson(response.toString(), Ownership.class);
        Dialog dialog = getDetailDialog(ownership);
        dialog.show();
    }

    private void showSnackBar(String message){
        Snackbar.make(findViewById(R.id.activity_create_route)
                , message
                , Snackbar.LENGTH_SHORT).show();
    }

    private void changeTitleTypeface(){
        final Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/Century-Gothic-Bold.ttf");
        collapsingToolbar.setCollapsedTitleTypeface(tf);
        collapsingToolbar.setExpandedTitleTypeface(tf);
    }

    private void animateButton(boolean visible){
        TransitionManager.beginDelayedTransition(container, new Slide(Gravity.RIGHT));
        currentRouteButton.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    private AlertDialog getDetailDialog(Ownership ownership) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = View.inflate(context, R.layout.dialog_ownership_detail, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();

        CenturyRegularTextView addressLabel = view.findViewById(R.id.address_label);
        addressLabel.setText(ownership.getAddress());
        CenturyRegularTextView neighborhoodLabel = view.findViewById(R.id.neighborhood_label);
        neighborhoodLabel.setText(!TextUtils.isEmpty(ownership.getNeighborhood())
                ? ownership.getNeighborhood() : "No disponible");
        CenturyRegularTextView ownerLabel = view.findViewById(R.id.owner_label);
        ownerLabel.setText(ownership.getOwnerName());

        CenturyBoldButton addButton = view.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
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
