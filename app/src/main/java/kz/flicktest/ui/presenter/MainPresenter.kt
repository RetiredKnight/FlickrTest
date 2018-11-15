package kz.flicktest.ui.presenter

import android.widget.ArrayAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kz.flicktest.base.BasePresenter
import kz.flicktest.R
import kz.flicktest.network.api.API
import kz.flicktest.ui.views.MainView
import kz.flicktest.utils.API_KEY
import kz.flicktest.utils.FORMAT
import kz.flicktest.utils.METHOD
import kz.flicktest.utils.VALUE
import javax.inject.Inject

class MainPresenter(mainView: MainView) : BasePresenter<MainView>(mainView) {

    @Inject
    lateinit var api: API

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        view.hideLoading()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadImages(text: String) {
        view.showLoading()
        subscription = api
                .getFlickrPhotos(METHOD, API_KEY, text, FORMAT, VALUE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate {
                    view.hideLoading()
                }
                .subscribe(
                        {flickrPhotos -> view.updatePhotos(flickrPhotos)},
                        {view.showError(R.string.error)}
                )
    }

}