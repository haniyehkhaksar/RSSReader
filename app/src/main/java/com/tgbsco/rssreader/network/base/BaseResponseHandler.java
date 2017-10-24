package com.tgbsco.rssreader.network.base;

import android.content.Context;

import com.tgbsco.rssreader.network.ApiUtils;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class BaseResponseHandler<T extends BaseResponse> implements retrofit2.Callback<T> {
    private Context context;
    private OnResponseListener listener;

    public BaseResponseHandler(Context context, OnResponseListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        int code = response.code();

        if (code == 200) {

            listener.onSuccess(response.body());

        } else {

            listener.onError(ApiUtils.getHttpErrorMessage(context, code));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        if (t.getMessage() != null && t.getMessage().startsWith("failed to connect")) {
            listener.onError(ApiUtils.getHttpErrorMessage(context, 504));
        } else {
            listener.onError(t.getMessage());
        }
    }
}
