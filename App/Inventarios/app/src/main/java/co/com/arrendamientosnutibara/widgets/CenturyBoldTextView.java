package co.com.arrendamientosnutibara.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by jva807 on 18/07/2017.
 */

public class CenturyBoldTextView extends AppCompatTextView {
    public CenturyBoldTextView(Context context) {
        super(context);
        init();
    }

    public CenturyBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CenturyBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Century-Gothic-Bold.ttf");
        setTypeface(tf);
    }
}
