package com.tgbsco.rssreader.utils.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.tgbsco.rssreader.utils.farsi.Farsi;
import com.tgbsco.rssreader.utils.farsi.FormatHelper;
import com.tgbsco.rssreader.utils.font.FontFactory;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class TextViewFarsi extends AppCompatTextView {

    public TextViewFarsi(Context context) {
        super(context);
        setTypeface(FontFactory.getInstance(context).getIRSANSMOBILE());
    }

    public TextViewFarsi(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(FontFactory.getInstance(context).getIRSANSMOBILE());
    }

    public TextViewFarsi(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(FontFactory.getInstance(context).getIRSANSMOBILE());
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        String persianText = FormatHelper.toPersianNumber(text.toString());
        super.setText(Farsi.Convert(persianText), type);
    }
}
