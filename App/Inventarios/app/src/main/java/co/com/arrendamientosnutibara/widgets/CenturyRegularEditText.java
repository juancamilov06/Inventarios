package co.com.arrendamientosnutibara.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;

/**
 * Created by jva807 on 19/07/2017.
 */

public class CenturyRegularEditText extends TextInputEditText {
    public CenturyRegularEditText(Context context) {
        super(context);
        init();
    }

    public CenturyRegularEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CenturyRegularEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()){
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                    "fonts/Century-Gothic.ttf");
            setTypeface(tf);
        }
    }
}
