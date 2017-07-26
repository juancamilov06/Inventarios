package co.com.arrendamientosnutibara.main;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import co.com.arrendamientosnutibara.async.BasicDataInsert;
import co.com.arrendamientosnutibara.helpers.Utils;
import co.com.arrendamientosnutibara.interfaces.AsyncResult;
import co.com.arrendamientosnutibara.widgets.CenturyRegularTextView;

public class SplashActivity extends AppCompatActivity {

    private CenturyRegularTextView loadingLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadingLabel = (CenturyRegularTextView) findViewById(R.id.loading_label);
        Utils.startRotatingView(loadingLabel);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData(){
        AndroidNetworking.get("http://192.168.0.25:4567/basic")
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        new BasicDataInsert(new AsyncResult() {
                            @Override
                            public void isSuccessful(boolean success) {
                                if(success){
                                    goToLogin();
                                    return;
                                }
                                showErrorSnackbar("Error insertando los datos");
                            }
                        }).execute(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        showErrorSnackbar("Error en la descarga de los datos");
                    }
                });
    }

    private void showErrorSnackbar(String message){
        Snackbar.make(findViewById(R.id.activity_splash)
                , message
                , Snackbar.LENGTH_INDEFINITE)
                .setAction("Reintentar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getData();
                    }
                }).show();
    }

    private void goToLogin(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(SplashActivity.this, findViewById(R.id.image_logo), "logo");
                startActivity(intent, options.toBundle());
            }
        }, 3000);
    }
}
