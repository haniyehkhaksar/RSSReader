package com.tgbsco.rssreader.network;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class NonCacheApiClient implements Interceptor {
    private static Retrofit retrofit;
    private static OkHttpClient httpClient;

    private static NonCacheApiClient instance;
    private Context context;

    public static final String RSS_WS_BASE_URL="http://www.khabaronline.ir/";

    private NonCacheApiClient(Context context) {

        String baseUrl = RSS_WS_BASE_URL;

        this.context = context;

        httpClient = new OkHttpClient.Builder()
                .addInterceptor(this)
                .retryOnConnectionFailure(true)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    public static NonCacheApiClient getInstance(Context context) {
        if (instance == null)
            instance = new NonCacheApiClient(context);

        return instance;
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        return chain.proceed(request);
    }
}

