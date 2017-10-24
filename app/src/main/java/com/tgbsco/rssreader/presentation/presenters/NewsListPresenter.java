package com.tgbsco.rssreader.presentation.presenters;

import com.tgbsco.rssreader.domain.model.News;
import com.tgbsco.rssreader.presentation.ui.BaseView;

import java.util.List;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface NewsListPresenter extends BasePresenter {

    void getAllNews();

    interface View extends BaseView {

        void showNews(List<News> newsList);

        void onClickNewsItem(String title, String url);
    }
}
