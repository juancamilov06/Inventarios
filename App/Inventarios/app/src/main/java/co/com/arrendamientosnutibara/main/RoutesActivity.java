package co.com.arrendamientosnutibara.main;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import co.com.arrendamientosnutibara.adapters.RouteAdapter;
import co.com.arrendamientosnutibara.async.RoutesOperations;
import co.com.arrendamientosnutibara.entities.Route;
import co.com.arrendamientosnutibara.helpers.Utils;
import co.com.arrendamientosnutibara.interfaces.AsyncObjectResult;


public class RoutesActivity extends AppCompatActivity {

    private RecyclerView routesRecycler;
    private Dialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        loading = Utils.getLoadingDialog(this);

        routesRecycler = (RecyclerView) findViewById(R.id.routes_recycler);
        routesRecycler.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.route_logo).setTransitionName("route");
        }

        setRoutes();
    }

    public void setRoutes(){
        loading.show();
        RoutesOperations.getActiveRoutes(new AsyncObjectResult() {
            @Override
            public void isSuccessful(Object result) {
                loading.dismiss();
                List<Route> routes = (List<Route>) result;
                if (routes != null) {
                    routesRecycler.setAdapter(new RouteAdapter(R.layout.item_route, routes));
                }
            }
        }).execute();
    }

}
