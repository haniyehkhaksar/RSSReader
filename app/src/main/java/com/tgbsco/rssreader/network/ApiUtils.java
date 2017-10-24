package com.tgbsco.rssreader.network;

import android.content.Context;

import com.tgbsco.rssreader.R;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class ApiUtils {

    public static String getHttpErrorMessage(Context context, int statusCode) {

        switch (statusCode) {
            case 504: {
                return context.getString(R.string.network_504);
            }

            case 500: {
                return context.getString(R.string.network_500);
            }
            case 404: {
                return context.getString(R.string.network_404);
            }
            case 403: {
                return context.getString(R.string.network_403);
            }

            case 401: {
                return context.getString(R.string.network_401);
            }

            default:
                return context.getString(R.string.network_unknown);

        }
    }


}
