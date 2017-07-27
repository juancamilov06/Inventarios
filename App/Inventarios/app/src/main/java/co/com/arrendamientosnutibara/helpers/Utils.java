package co.com.arrendamientosnutibara.helpers;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import co.com.arrendamientosnutibara.application.NutibaraApplication;
import co.com.arrendamientosnutibara.entities.UserDao;
import co.com.arrendamientosnutibara.main.R;

/**
 * Created by jva807 on 21/07/2017.
 */

public class Utils {

    public static String getAuthToken(){
        UserDao userDao = NutibaraApplication.getApplicationInstance().getDaoSession().getUserDao();
        return userDao.queryBuilder().where(UserDao.Properties.Id.eq(1)).unique().getToken();
    }

    public static long getRandId(){
        long leftLimit = 0L;
        long rightLimit = Long.MAX_VALUE;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public static Dialog getLoadingDialog(Context context){

        Dialog dialog = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        View view = View.inflate(context, R.layout.dialog_loading, null);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(view);
        startRotatingView(view.findViewById(R.id.loading_logo));
        return dialog;
    }

    public static void startRotatingView(View view){

        ObjectAnimator animation = ObjectAnimator.ofFloat(view, "rotationY", 0.0f, 360f);
        animation.setDuration(3000);
        animation.setRepeatMode(ObjectAnimator.RESTART);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();

    }

}
