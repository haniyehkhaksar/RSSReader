package com.tgbsco.rssreader.domain.interactors.impl;

import com.tgbsco.rssreader.domain.executer.Executor;
import com.tgbsco.rssreader.domain.executer.MainThread;
import com.tgbsco.rssreader.domain.interactors.GetAllNewsInteractor;
import com.tgbsco.rssreader.domain.interactors.base.AbstractInteractor;
import com.tgbsco.rssreader.domain.model.News;
import com.tgbsco.rssreader.domain.repository.NewsRepository;

import java.util.List;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public class GetAllNewsInteractorImpl extends AbstractInteractor implements GetAllNewsInteractor {

    private Callback callback;
    private NewsRepository newsRepository;

    public GetAllNewsInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                    NewsRepository newsRepository, Callback callback) {
        super(threadExecutor, mainThread);

        if (newsRepository == null || callback == null) {
            throw new IllegalArgumentException("Arguments can not be null!");
        }

        this.callback = callback;
        this.newsRepository = newsRepository;
    }

    @Override
    public void run() {

        // retrieve the news from the database
        newsRepository.getAllNews(new Callback() {
            @Override
            public void onNewsRetrieved(final List<News> newsList) {

                mMainThread.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onNewsRetrieved(newsList);
                    }
                });

            }
        });

        // Show news on the main thread

    }

}
