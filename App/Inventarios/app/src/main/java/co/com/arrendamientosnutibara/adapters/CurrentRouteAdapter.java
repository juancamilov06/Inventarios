package co.com.arrendamientosnutibara.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.com.arrendamientosnutibara.entities.Ownership;
import co.com.arrendamientosnutibara.main.R;
import co.com.arrendamientosnutibara.widgets.CenturyRegularTextView;

/**
 * Created by jva807 on 21/07/2017.
 */

public class CurrentRouteAdapter extends RecyclerView.Adapter<CurrentRouteAdapter.ViewHolder>{


    private final int resource;
    private final List<Ownership> ownerships;

    public CurrentRouteAdapter(int resource, List<Ownership> ownerships){
        this.resource = resource;
        this.ownerships = ownerships;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ownership ownership = ownerships.get(position);
        if (ownership != null){
            holder.addressLabel.setText(ownership.getAddress());
            holder.codeLabel.setText(String.valueOf(ownership.getId()));
            holder.neighborhood.setText(ownership.getNeighborhood());
        }
    }

    @Override
    public int getItemCount() {
        return ownerships.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CenturyRegularTextView codeLabel, addressLabel, neighborhood;

        ViewHolder(View view) {
            super(view);
            this.neighborhood = view.findViewById(R.id.neighborhood_label);
            this.addressLabel = view.findViewById(R.id.address_label);
            this.codeLabel = view.findViewById(R.id.code_label);
        }
    }

}
