package com.tgbsco.rssreader.presentation.presenters;


import com.tgbsco.rssreader.domain.executer.Executor;
import com.tgbsco.rssreader.domain.executer.MainThread;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public abstract class AbstractPresenter {

    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
