package co.com.arrendamientosnutibara.application;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import co.com.arrendamientosnutibara.entities.DaoMaster;
import co.com.arrendamientosnutibara.entities.DaoSession;

/**
 * Created by jva807 on 21/07/2017.
 */

public class NutibaraApplication extends Application {

    private DaoSession daoSession;
    private static NutibaraApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "inventory-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        instance = this;
    }

    public static NutibaraApplication getApplicationInstance(){
        return instance;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

}
