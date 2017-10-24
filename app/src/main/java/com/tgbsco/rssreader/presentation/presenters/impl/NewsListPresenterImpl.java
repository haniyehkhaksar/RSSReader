package com.tgbsco.rssreader.presentation.presenters.impl;

import com.tgbsco.rssreader.domain.executer.Executor;
import com.tgbsco.rssreader.domain.executer.MainThread;
import com.tgbsco.rssreader.domain.interactors.GetAllNewsInteractor;
import com.tgbsco.rssreader.domain.interactors.impl.GetAllNewsInteractorImpl;
import com.tgbsco.rssreader.domain.model.News;
import com.tgbsco.rssreader.domain.repository.NewsRepository;
import com.tgbsco.rssreader.presentation.presenters.AbstractPresenter;
import com.tgbsco.rssreader.presentation.presenters.NewsListPresenter;

import java.util.List;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class NewsListPresenterImpl extends AbstractPresenter implements NewsListPresenter, GetAllNewsInteractor.Callback {

    private NewsListPresenter.View view;
    private NewsRepository newsRepository;

    public NewsListPresenterImpl(Executor executor, MainThread mainThread,
                                 NewsListPresenter.View view, NewsRepository newsRepository) {
        super(executor, mainThread);

        this.view = view;
        this.newsRepository = newsRepository;
    }

    @Override
    public void resume() {

        getAllNews();
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void getAllNews() {

        GetAllNewsInteractor getAllNewsInteractor = new GetAllNewsInteractorImpl(mExecutor, mMainThread, newsRepository, this);
        getAllNewsInteractor.execute();
    }

    @Override
    public void onNewsRetrieved(List<News> newsList) {

        view.showNews(newsList);
    }
}
