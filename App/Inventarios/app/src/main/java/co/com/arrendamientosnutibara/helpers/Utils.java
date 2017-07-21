package co.com.arrendamientosnutibara.helpers;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import co.com.arrendamientosnutibara.application.NutibaraApplication;
import co.com.arrendamientosnutibara.main.R;

/**
 * Created by jva807 on 21/07/2017.
 */

public class Utils {

    public static Dialog getLoadingDialog(Context context){

        Dialog dialog = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        View view = View.inflate(context, R.layout.dialog_loading, null);
        dialog.setContentView(view);

        ObjectAnimator animation = ObjectAnimator.ofFloat(view.findViewById(R.id.loading_logo), "rotationY", 0.0f, 360f);

        animation.setDuration(1000);
        animation.setRepeatMode(ObjectAnimator.RESTART);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();

        return dialog;
    }

}
