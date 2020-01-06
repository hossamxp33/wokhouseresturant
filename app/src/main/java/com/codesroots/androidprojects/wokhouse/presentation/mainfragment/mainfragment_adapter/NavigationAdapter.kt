package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.mainfragment_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.androidprojects.wokhouse.databinding.BottomNavigationRowBinding
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model.PageViewModel
import com.codesroots.androidprojects.wokhouse.R


class NavigationAdapter(val  viewModel: PageViewModel): RecyclerView.Adapter<NavigationAdapter.CustomViewHolder>() {

    val row_title = listOf("الرئيسية", "تقييم زيارتك", "عن وك هاوس")





    override fun getItemCount(): Int {
        return  row_title.size
    }

// Change Color ONclick !!!!!!!!!!

    var row_index = 0;

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(viewModel,p1,row_title.get(p1))




    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

        val binding: BottomNavigationRowBinding = DataBindingUtil.inflate (LayoutInflater.from(p0.context),
        R.layout.bottom_navigation_row,p0,false)

        return CustomViewHolder(binding)
    }


    class CustomViewHolder(
        private val binding: BottomNavigationRowBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(viewModel:PageViewModel, index:Int,string: String) {

            binding.index = index
            binding.viewmodel = viewModel
    binding.name = string
        }
    }




}