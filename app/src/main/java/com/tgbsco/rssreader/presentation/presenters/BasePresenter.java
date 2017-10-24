package com.tgbsco.rssreader.presentation.presenters;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface BasePresenter {

    void resume();

    void pause();

    void stop();

    void destroy();

    void onError(String message);
}
