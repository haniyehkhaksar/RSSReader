package com.tgbsco.rssreader.network.base;

import android.content.Context;

import com.tgbsco.rssreader.utils.Utils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class ApiClient implements Interceptor {
    private static Retrofit retrofit;
    private static OkHttpClient httpClient;

    private static ApiClient instance;
    private Context context;

    public static final String RSS_WS_BASE_URL = "http://www.khabaronline.ir/";

    private ApiClient(Context context) {
        String baseUrl = RSS_WS_BASE_URL;

        this.context = context;

        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 100 * 1024 * 1024; // 100 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);


//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        httpClient = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
                .addInterceptor(this)
                .cache(cache)
                .retryOnConnectionFailure(true)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    public static ApiClient getInstance(Context context) {
        if (instance == null)
            instance = new ApiClient(context);

        return instance;
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (Utils.isNetworkAvailable(context)) {
            int maxAge = 60; // read from cache for 1 minute
            request = request.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return chain.proceed(request);
    }
}

