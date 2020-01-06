package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper

import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.model.CategoryModel
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.fragments.FragmentOne
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model.PageViewModel
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.adapter.MainAdpter
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.categories_main.*



class DepartmentDetailActivity(): AppCompatActivity() {

    private lateinit var pageViewModel: PageViewModel
      var  data : CategoryModel? = null

       val adapter = ViewPagerAdapter(supportFragmentManager)

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories_main)


        var extras = intent.extras
        val value = extras!!.getInt("position")
        data = extras!!.getParcelable("myobj")
        ///////////// Recycle View Rows /////////////////

        recycelView_main.layoutManager = LinearLayoutManager(this ,OrientationHelper.HORIZONTAL ,true)

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel:: class.java)

        recycelView_main.adapter = MainAdpter(pageViewModel,applicationContext , data!!)


        for (item in data!!.data!!) {
            adapter.addFragment(FragmentOne(item.subcategories!!),"")
        }
        viewpager.adapter = adapter
        viewpager.currentItem = value

        pageViewModel.CompanyResponseLD?.observe(this , Observer {
            adapter.notifyDataSetChanged()
            viewpager.currentItem = it

        })
    }


    }



