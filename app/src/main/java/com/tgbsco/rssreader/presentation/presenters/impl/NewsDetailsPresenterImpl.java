package com.tgbsco.rssreader.presentation.presenters.impl;

import com.tgbsco.rssreader.domain.executer.Executor;
import com.tgbsco.rssreader.domain.executer.MainThread;
import com.tgbsco.rssreader.presentation.presenters.AbstractPresenter;
import com.tgbsco.rssreader.presentation.presenters.NewsDetailsPresenter;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class NewsDetailsPresenterImpl extends AbstractPresenter implements NewsDetailsPresenter {

    private NewsDetailsPresenter.View view;

    public NewsDetailsPresenterImpl(Executor executor, MainThread mainThread,
                                    NewsDetailsPresenter.View view) {
        super(executor, mainThread);

        this.view = view;
    }

    @Override
    public void resume() {

        view.showNewsItem();
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
