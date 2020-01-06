package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.mainfragment_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.databinding.MenuRowCategoryBinding
import com.codesroots.androidprojects.wokhouse.model.CategoryData
import com.codesroots.androidprojects.wokhouse.model.CategoryModel
import com.codesroots.androidprojects.wokhouse.presentation.ClickHandler
import com.codesroots.androidprojects.wokhouse.presentation.MainActivity
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model.PageViewModel


class MenuAdapter(var viewmodel: PageViewModel,var activity: FragmentActivity,var menu: CategoryModel): RecyclerView.Adapter<MenuAdapter.CustomViewHolder>() {

    private val menusData: CategoryModel = menu



    override fun getItemCount(): Int {
        return menusData.data!!.count()
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val binding: MenuRowCategoryBinding
                =DataBindingUtil.inflate (LayoutInflater.from(p0.context),R.layout.menu_row_category,p0,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(p1,activity,menu.data!!.get(p1),menu)
    }




    class CustomViewHolder (
        private val binding: MenuRowCategoryBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position:Int, context: Context?, data: CategoryData,datamodel:CategoryModel) {

            binding.listener = ClickHandler()
            binding.data = data
            binding.context = context as MainActivity
            binding.datamodel = datamodel
            binding.index = position
        }

        }


    }

