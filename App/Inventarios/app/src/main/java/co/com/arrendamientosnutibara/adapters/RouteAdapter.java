package co.com.arrendamientosnutibara.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.ocpsoft.pretty.time.PrettyTime;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import co.com.arrendamientosnutibara.entities.Ownership;
import co.com.arrendamientosnutibara.entities.Route;
import co.com.arrendamientosnutibara.main.R;
import co.com.arrendamientosnutibara.widgets.CenturyRegularTextView;

/**
 * Created by jva807 on 27/07/2017.
 */

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.ViewHolder>{

    private List<Route> routes;
    private int resource;

    public RouteAdapter(int resource, List<Route> routes){
        this.resource = resource;
        this.routes = routes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Route route = routes.get(position);
        holder.dateLabel.setText(getPeriodOfTime(route));
        holder.progressBar.setProgress(getCurrentProgress(route));
    }

    private String getPeriodOfTime(Route route){
        PrettyTime time = new PrettyTime(new Locale("es"));
        return time.format(new Date(route.getCreated()));
    }

    private int getCurrentProgress(Route route){
        List<Ownership> ownerships = route.getOwnershipsInRoute();
        if(ownerships.size() == 0){
            return 0;
        }
        return Math.round((countFinishedOwnerships(ownerships) * 100)/ownerships.size());
    }

    private int countFinishedOwnerships(List<Ownership> ownerships){
        int finished = 0;
        for (Ownership ownership: ownerships) {
            if (ownership.getIsActive()){
                finished++;
            }
        }
        return finished;
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private NumberProgressBar progressBar;
        private CenturyRegularTextView dateLabel;

        public ViewHolder(View view) {
            super(view);
            this.progressBar = view.findViewById(R.id.progress_bar);
            this.dateLabel = view.findViewById(R.id.date_label);
        }
    }

}
