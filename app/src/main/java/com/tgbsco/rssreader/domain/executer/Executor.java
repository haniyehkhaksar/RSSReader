package com.tgbsco.rssreader.domain.executer;

import com.tgbsco.rssreader.domain.interactors.base.AbstractInteractor;

/**
 * Created by h.khaksar on 10/24/2017.
 */

public interface Executor {

    void execute(final AbstractInteractor interactor);
}
