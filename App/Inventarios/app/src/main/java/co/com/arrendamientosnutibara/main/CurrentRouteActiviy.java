package co.com.arrendamientosnutibara.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import co.com.arrendamientosnutibara.adapters.CurrentRouteAdapter;
import co.com.arrendamientosnutibara.entities.Ownership;

public class CurrentRouteActiviy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Ownership> ownerships = getOwnerships();
        RecyclerView ownershipsRecycler = (RecyclerView) findViewById(R.id.ownerships_recycler);
        ownershipsRecycler.setLayoutManager(new LinearLayoutManager(this));
        ownershipsRecycler.setAdapter(new CurrentRouteAdapter(R.layout.item_ownership, ownerships));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private List<Ownership> getOwnerships(){
        List<Ownership> ownerships = new ArrayList<>();

        Ownership ownership = new Ownership();
        ownership.setAddress("CRR 88 N° 44 - 45");
        ownership.setId(820004);
        ownership.setNeighborhood("La America");
        ownerships.add(ownership);

        ownership = new Ownership();
        ownership.setAddress("CLL 10 N° 39 - 40");
        ownership.setId(820741);
        ownership.setNeighborhood("El Poblado");
        ownerships.add(ownership);

        return ownerships;
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
