package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel


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