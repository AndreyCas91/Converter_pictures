package com.gb.converter_pictures.ui.main

import com.gb.converter_pictures.screens.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(AppScreens.converterScreen())
    }

    fun backClicked() {
        router.exit()
    }
}