package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.mainfragment_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.databinding.MenuRowBinding
import com.codesroots.androidprojects.wokhouse.model.*
import com.codesroots.androidprojects.wokhouse.presentation.ClickHandler

import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.DepartmentDetailActivity
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model.PageViewModel

class menuRowAdapter(var viewmodel:PageViewModel, var activity: Context?, var menu: List<Subcategory>):
    RecyclerView.Adapter<menuRowAdapter.CustomViewHolder1>() {



    override fun getItemCount(): Int {
        return  menu.size
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder1 {
        val menubinding: MenuRowBinding = DataBindingUtil.inflate (LayoutInflater.from(p0.context),R.layout.menu_row,p0,
            false)

        return CustomViewHolder1(menubinding)

    }

    var row_index = 0;
    override fun onBindViewHolder(p0:CustomViewHolder1, p1: Int){
        p0.bind(viewmodel,activity,menu.get(p1))
    }


    class CustomViewHolder1 (
        private val binding: MenuRowBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(viewModel: PageViewModel, context: Context?, data: Subcategory) {

            binding.data = data
            binding.context = context as DepartmentDetailActivity
            binding.viewmodel = viewModel
            binding.listener = ClickHandler()

        }

    }
}