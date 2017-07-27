package co.com.arrendamientosnutibara.async;

import android.os.AsyncTask;

import java.util.List;

import co.com.arrendamientosnutibara.application.NutibaraApplication;
import co.com.arrendamientosnutibara.entities.Route;
import co.com.arrendamientosnutibara.entities.RouteDao;
import co.com.arrendamientosnutibara.helpers.Utils;
import co.com.arrendamientosnutibara.interfaces.AsyncObjectResult;
import co.com.arrendamientosnutibara.interfaces.AsyncResult;

/**
 * Created by jva807 on 27/07/2017.
 */

public class RoutesOperations {

    public static AsyncTask<Void, Void, List<Route>> getActiveRoutes(final AsyncObjectResult delegate){
        return new AsyncTask<Void, Void, List<Route>>() {
            @Override
            protected List<Route> doInBackground(Void... voids) {
                return NutibaraApplication.getApplicationInstance()
                        .getDaoSession().getRouteDao().queryBuilder()
                        .where(RouteDao.Properties.Is_finished.eq(false)).list();
            }

            @Override
            protected void onPostExecute(List<Route> routes) {
                super.onPostExecute(routes);
                delegate.isSuccessful(routes);
            }
        };
    }

    public static AsyncTask<Void, Void, Boolean> getHasActiveRoutes(final AsyncResult delegate){
        return new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                return NutibaraApplication.getApplicationInstance()
                        .getDaoSession().getRouteDao().queryBuilder()
                        .where(RouteDao.Properties.Is_finished.eq(false)).count() > 0;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                super.onPostExecute(result);
                delegate.isSuccessful(result);
            }
        };
    }



    public static AsyncTask<Void, Void, Long> createRoute(final AsyncObjectResult delegate){
        return new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                long genId = Utils.getRandId();
                Route route = new Route(genId, false, System.currentTimeMillis());
                return NutibaraApplication.getApplicationInstance()
                        .getDaoSession().getRouteDao().insert(route);
            }
            @Override
            protected void onPostExecute(Long result) {
                super.onPostExecute(result);
                delegate.isSuccessful(result);
            }
        };
    }

}
