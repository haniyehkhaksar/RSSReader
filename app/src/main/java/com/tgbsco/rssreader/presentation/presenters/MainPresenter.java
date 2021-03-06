package com.tgbsco.rssreader.presentation.presenters;

import com.tgbsco.rssreader.presentation.ui.BaseView;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {

        void showNewsListFragment();

        void showNewsDetailsBottomDialog(String title, String url);
    }

}
