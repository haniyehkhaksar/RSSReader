package com.tgbsco.rssreader.utils.font;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class FontFactory {

    private static Typeface IRSANSMOBILE;
    private static Typeface IRSANSBOLD;

    private static FontFactory instance;

    private FontFactory(Context context) {

        IRSANSMOBILE = Typeface.createFromAsset(context.getAssets(), "fonts/irsansmobile.ttf");
        IRSANSBOLD = Typeface.createFromAsset(context.getAssets(), "fonts/irsansbold.ttf");
    }

    public static FontFactory getInstance(Context context) {
        if (instance == null)
            instance = new FontFactory(context);
        return instance;
    }

    public Typeface getIRSANSMOBILE() {

        return IRSANSMOBILE;
    }

    public Typeface getIRSANSBOLD() {
        return IRSANSBOLD;
    }

}
