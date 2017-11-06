package zenlife.nox.noxcomic.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import zenlife.nox.noxcomic.R;

/**
 * Created by Nhan on 11/4/2017.
 */

public class NoyhrFontTextView extends AppCompatTextView {
    public NoyhrFontTextView(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/noyhr.otf");
        this.setTypeface(face);
        this.setTextColor(getResources().getColor(R.color.colorMainText));
    }

    public NoyhrFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/noyhr.otf");
        this.setTypeface(face);
        this.setTextColor(getResources().getColor(R.color.colorMainText));
    }

    public NoyhrFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/noyhr.otf");
        this.setTypeface(face);
        this.setTextColor(getResources().getColor(R.color.colorMainText));
    }
}
