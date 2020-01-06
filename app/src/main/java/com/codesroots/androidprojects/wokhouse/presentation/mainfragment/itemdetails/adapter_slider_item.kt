package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.itemdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.model.ItemData
import com.codesroots.androidprojects.wokhouse.model.ItemPhoto
import kotlinx.android.synthetic.main.viewpagerslide.view.*


class ItemSliderAdapter(var activity: Context?, var sliders: List<ItemPhoto>) : PagerAdapter() {

    private val context: Context

    private val slidersData: List<ItemPhoto> = sliders

    init {
        this.context =  activity!!
    }

    override fun getCount(): Int {
        return  slidersData.size
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1 //To change body of created functions use File | Settings | File Templates.
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.viewpagerslide, container, false)
        loudImage(context,view.im_slider,slidersData[position].photo)
        container.addView(view)
        return view
    }

    fun loudImage(context: Context, imag: ImageView, url: String?) {
        Glide.with(context).applyDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.home)
                .error(R.drawable.home)).load(url).into(imag)
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}
