package com.tgbsco.rssreader.domain.repository;

import com.tgbsco.rssreader.domain.interactors.GetAllNewsInteractor;
import com.tgbsco.rssreader.domain.model.News;

import java.util.List;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface NewsRepository {

    void getAllNews(GetAllNewsInteractor.Callback callback);

}
