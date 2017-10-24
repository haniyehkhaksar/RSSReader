package com.tgbsco.rssreader.network.base;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface OnResponseListener {

    void onSuccess(BaseResponse baseResponse) ;

    void onError(String error) ;
}

