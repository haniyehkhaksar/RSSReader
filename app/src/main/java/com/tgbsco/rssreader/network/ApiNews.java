package com.tgbsco.rssreader.network;

import android.content.Context;

import com.tgbsco.rssreader.domain.interactors.GetAllNewsInteractor;
import com.tgbsco.rssreader.network.base.ApiClient;
import com.tgbsco.rssreader.network.base.BaseResponseHandler;
import com.tgbsco.rssreader.presentation.model.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class ApiNews {

    private interface NewsApi
    {
        @GET("RSS")
        Call<NewsList> getNewsList();
    }

    private Context context ;
    private static NewsApi postsApi ;
    private static ApiNews instance ;

    private ApiNews(Context context)
    {
        this.context = context ;

        postsApi = ApiClient.getInstance(context).getRetrofit().create(NewsApi.class);
    }

    public static ApiNews getInstance(Context context){
        if(instance == null)
            instance = new ApiNews(context);
        return instance ;
    }

    public void getNewsList(final GetAllNewsInteractor.Callback listener){

        final Call<NewsList> callNewsList = postsApi.getNewsList();

//        callNewsList.enqueue(new BaseResponseHandler<NewsList>(context,listener));

    }


}

