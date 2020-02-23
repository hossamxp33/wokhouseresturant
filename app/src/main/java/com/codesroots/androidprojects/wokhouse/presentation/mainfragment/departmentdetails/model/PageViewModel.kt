package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import android.graphics.drawable.Drawable
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.codesroots.androidprojects.wokhouse.R


class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    var CompanyResponseLD : MutableLiveData<Int>? = null

    init {
        CompanyResponseLD = MutableLiveData()
    }

    fun setIndex(index: Int) {
        CompanyResponseLD!!.postValue(index)

        }


    }
