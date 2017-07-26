package co.com.arrendamientosnutibara.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import co.com.arrendamientosnutibara.application.NutibaraApplication;
import co.com.arrendamientosnutibara.entities.DaoSession;
import co.com.arrendamientosnutibara.entities.User;
import co.com.arrendamientosnutibara.entities.UserDao;
import co.com.arrendamientosnutibara.widgets.CenturyBoldButton;
import co.com.arrendamientosnutibara.widgets.CenturyRegularEditText;

public class LoginActivity extends AppCompatActivity {

    private CenturyRegularEditText codeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        codeInput = (CenturyRegularEditText) findViewById(R.id.code_input);

        CenturyBoldButton loginButton = (CenturyBoldButton) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code = codeInput.getText().toString();
                if (TextUtils.isEmpty(code)){
                    showSnackBar("Debes ingresar el codigo de empleado");
                    return;
                }

                try {
                    AndroidNetworking.post("http://192.168.0.25:4567/auth")
                            .addJSONObjectBody(new JSONObject().put("code", code))
                            .setPriority(Priority.IMMEDIATE)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    checkSession(response);
                                }

                                @Override
                                public void onError(ANError anError) {
                                    System.out.println("ERROR: " + anError.getErrorBody());
                                }
                            });
                } catch (JSONException e) {
                    showSnackBar("Hubo un error ingresando tu codigo");
                    e.printStackTrace();
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.image_logo).setTransitionName("logo");
        }
    }

    private void showSnackBar(String message){
        Snackbar.make(findViewById(R.id.activity_login)
                , message
                , Snackbar.LENGTH_SHORT).show();
    }

    private void checkSession(JSONObject response){
        try {
            int code = response.getInt("code");
            boolean success = response.getBoolean("success");
            if(code == 200 && success){
                String token = response.getString("token");
                System.out.println("Token:" + token);
                DaoSession session = NutibaraApplication.getApplicationInstance().getDaoSession();
                UserDao userDao = session.getUserDao();
                userDao.insertOrReplace(new User(1, token));
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
