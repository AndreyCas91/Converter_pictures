package com.gb.converter_pictures.ui.converter

import android.net.Uri
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.gb.converter_pictures.model.WorkingWithFiles
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter


class ConverterPresenter(private val router: Router, private val fragment: Fragment) :
    MvpPresenter<ConverterView>() {

    private val fileConverter = WorkingWithFiles()

    private var uri: Uri? = null

    fun onButtonClicked() {

        fileConverter.producer()
            .observeOn(Schedulers.computation())
            .subscribe({
                getResult.launch("image/*")
                Thread.sleep(7000)
                /*
                * В этом месте вызывал бы функцию которая создаст новый файл по пути Uri.
                * Только не понимаю как это сделать
                *
                *
                * */
            },
                { Log.e("Error", "Ошибка загрузки", it) }
            )

    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    private val getResult =
        fragment.registerForActivityResult(ActivityResultContracts.GetContent()) {
            uri = it
        }

}

