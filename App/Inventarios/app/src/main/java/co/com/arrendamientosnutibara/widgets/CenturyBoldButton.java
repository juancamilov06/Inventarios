package co.com.arrendamientosnutibara.widgets;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by jva807 on 19/07/2017.
 */

public class CenturyBoldButton extends AppCompatButton {

    public CenturyBoldButton(Context context) {
        super(context);
        init();
    }

    public CenturyBoldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CenturyBoldButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Century-Gothic-Bold.ttf");
        setTypeface(tf);
    }
}
