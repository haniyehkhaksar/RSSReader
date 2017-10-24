package com.tgbsco.rssreader.presentation.model;

import android.content.Context;

import com.tgbsco.rssreader.domain.interactors.GetAllNewsInteractor;
import com.tgbsco.rssreader.domain.model.News;
import com.tgbsco.rssreader.network.base.BaseResponseHandler;

import java.util.List;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class NewsList extends BaseResponseHandler {

    private List<News> newsList;

    public NewsList(Context context, GetAllNewsInteractor.Callback callback, List<News> newsList) {
        super(context, callback);
        this.newsList = newsList;
    }

    public List<News> getNewsList() {
        return newsList;
    }


    @Override
    public String toString() {
        return "AllNews { newsList = " + newsList + '}';
    }
}
