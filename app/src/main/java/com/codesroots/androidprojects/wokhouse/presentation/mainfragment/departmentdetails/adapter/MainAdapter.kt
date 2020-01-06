package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.databinding.TopRowPostBinding
import com.codesroots.androidprojects.wokhouse.model.CategoryData
import com.codesroots.androidprojects.wokhouse.model.CategoryModel
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model.PageViewModel


class MainAdpter(var viewmodel: PageViewModel, var  activity: Context?, var sliders: CategoryModel): RecyclerView.Adapter<MainAdpter.CustomViewHolder>() {

    private val slidersData: CategoryModel = sliders

    override fun getItemCount(): Int {

        return  slidersData.data!!.size
    }

    var   row_index = 0

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {

        p0.bind(viewmodel,activity,slidersData.data!!.get(p1),p1)
if (row_index == p1)
{


}
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

        val  binding: TopRowPostBinding = DataBindingUtil.inflate (LayoutInflater.from(p0.context),R.layout.top_row_post,p0,false)

        return  CustomViewHolder(binding)
    }

    class CustomViewHolder (
        private val binding:TopRowPostBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(viewModel:PageViewModel, context: Context?, data: CategoryData,index:Int) {

            binding.data = data
            binding.index = index
            binding.viewmodel = viewModel
        }

    }
}
