package com.tgbsco.rssreader.domain.executer;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface MainThread {

    void post(final Runnable runnable);
}
