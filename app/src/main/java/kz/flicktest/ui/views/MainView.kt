package kz.flicktest.ui.views

import android.support.annotation.StringRes
import kz.flicktest.base.BaseView
import kz.flicktest.network.model.FlickrPhotos

interface MainView: BaseView {

    fun updatePhotos(photos : FlickrPhotos)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()

}