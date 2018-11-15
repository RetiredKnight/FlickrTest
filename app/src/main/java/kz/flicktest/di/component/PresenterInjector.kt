package kz.flicktest.di.component

import dagger.BindsInstance
import dagger.Component
import kz.flicktest.base.BaseView
import kz.flicktest.di.module.ContextModule
import kz.flicktest.di.module.NetworkModule
import kz.flicktest.ui.presenter.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])

interface PresenterInjector {

    fun inject(mainPresenter: MainPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder


    }

}