package kz.flicktest.base

import kz.flicktest.di.component.DaggerPresenterInjector
import kz.flicktest.di.component.PresenterInjector
import kz.flicktest.di.module.ContextModule
import kz.flicktest.di.module.NetworkModule
import kz.flicktest.ui.presenter.MainPresenter

abstract class BasePresenter<out V : BaseView>(protected val view : V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    private fun inject() {
        when (this) {
            is MainPresenter -> injector.inject(this)
        }
    }

}