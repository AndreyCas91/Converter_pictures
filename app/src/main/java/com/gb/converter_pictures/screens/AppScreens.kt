package com.gb.converter_pictures.screens

import com.gb.converter_pictures.ui.converter.ConverterFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun converterScreen() = FragmentScreen {
        ConverterFragment()
    }
}