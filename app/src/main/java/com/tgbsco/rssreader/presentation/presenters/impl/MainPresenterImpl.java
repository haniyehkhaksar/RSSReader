package com.tgbsco.rssreader.presentation.presenters.impl;

import com.tgbsco.rssreader.domain.executer.Executor;
import com.tgbsco.rssreader.domain.executer.MainThread;
import com.tgbsco.rssreader.domain.repository.NewsRepository;
import com.tgbsco.rssreader.presentation.presenters.AbstractPresenter;
import com.tgbsco.rssreader.presentation.presenters.MainPresenter;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter {


    private MainPresenter.View view;
    private NewsRepository newsRepository;


    public MainPresenterImpl(Executor executor, MainThread mainThread,
                             View view) {
        super(executor, mainThread);
        this.view = view;
    }

    @Override
    public void resume() {

        view.showNewsListFragment();
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

}
