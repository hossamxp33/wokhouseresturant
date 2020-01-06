package com.codesroots.androidprojects.wokhouse.presentation.mainfragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.model.CategoryModel
import com.codesroots.androidprojects.wokhouse.model.SliderData
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.mainfragment_adapter.SliderAdapter
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.mainfragment_adapter.MenuAdapter
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model.PageViewModel


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.fragment_common.view.*
import okhttp3.*
import java.io.IOException
import java.util.*

class MainFragment : Fragment(){

    private lateinit var pageViewModel: PageViewModel
    var  data : CategoryModel? = null

    var pager: ViewPager? = null
    var indicator: CirclePageIndicator? = null


    var NUM_PAGES = 0
    var currentPage = 0

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  {

        var view = inflater.inflate(R.layout.fragment_common, container, false)

        pager = view!!.pager

        indicator = view.indicator

        Timer()
        getCategories()

        view.recycelView_main.layoutManager = GridLayoutManager(activity,2)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel:: class.java)


        fetchJson()
        return view



    }

    private fun init(size: Int) {
        val density = getResources().getDisplayMetrics().density
        indicator!!.setRadius(4 * density)

        NUM_PAGES = size
        val handler = Handler()
        val Update:Runnable =Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            pager?.setCurrentItem(currentPage++, true)
        }

        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 4000, 10000)
        indicator!!.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(pos: Int) {}
        })
    }



    private  fun fetchJson(){
        println("Attempting to Fetch Json")

        val url = "http://wokhouse.codesroots.com/api/sliders.json"

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val  body = response.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val items = Gson().fromJson(body, SliderData::class.java)

                activity!!.runOnUiThread {
                    pager!!.adapter = SliderAdapter(activity!!,items!!.data!!)
                    indicator!!.setViewPager(pager)
                    init(items.data!!.size)

                }
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }


    private  fun getCategories(){
        println("Attempting to Fetch Json")
        val url = "http://wokhouse.codesroots.com/api/Categories/getitemcategories.json?fbclid=IwAR0TlPjFkGzVyYW9JBnOtGwa2-W5hQbI8xLisw0pDiFWteiMmwWee9clEWQ"
        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val  body = response.body?.string()
                println(body)


                val gson = GsonBuilder().create()
                val items = Gson().fromJson(body, CategoryModel::class.java)

                activity!!.runOnUiThread {
                    data = items

                    view?.recycelView_main?.adapter = MenuAdapter(pageViewModel,
                        context as FragmentActivity, items )
                }

            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")

            }


        })
    }

}

