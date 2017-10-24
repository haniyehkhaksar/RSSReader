package com.tgbsco.rssreader.domain.interactors;

import com.tgbsco.rssreader.domain.interactors.base.Interactor;
import com.tgbsco.rssreader.domain.model.News;
import com.tgbsco.rssreader.network.base.OnResponseListener;

import java.util.List;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface GetAllNewsInteractor extends Interactor {

    interface Callback extends OnResponseListener {

        void onNewsRetrieved(List<News> newsList);
    }
}
