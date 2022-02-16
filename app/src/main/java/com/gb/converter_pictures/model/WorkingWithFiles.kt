package com.gb.converter_pictures.model

import android.content.Intent
import android.os.Build
import android.util.Log
import io.reactivex.rxjava3.core.Completable


class WorkingWithFiles() {

    private fun createCopyFile() {
        Log.d("Test", "test 1111111111111111111111111111111111")
    }

    private fun goToFileProviderFragment() {
        val mimeTypes =
            arrayOf("image/jpg")
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent.type = if (mimeTypes.size == 1) mimeTypes[0] else "*/*"
            if (mimeTypes.isNotEmpty()) {
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            }
        } else {
            var mimeTypesStr = ""
            for (mimeType in mimeTypes) {
                mimeTypesStr += "$mimeType|"
            }
            intent.type = mimeTypesStr.substring(0, mimeTypesStr.length - 1)
        }

    }

    fun producer() = Completable.create{
        goToFileProviderFragment()
        it.onComplete()
    }
}
