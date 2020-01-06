package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.model.Subcategory
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.mainfragment_adapter.menuRowAdapter
import com.codesroots.androidprojects.wokhouse.presentation.mainfragment.departmentdetails.model.PageViewModel
import kotlinx.android.synthetic.main.categories_menu_detail.view.*

/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNREACHABLE_CODE")
class FragmentOne (var datavar:List<Subcategory>) : Fragment() {
    private lateinit var pageViewModel: PageViewModel
var adapter : menuRowAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.categories_menu_detail, container, false)


        view.recycelView_menu_row.layoutManager = LinearLayoutManager(activity)
        pageViewModel = ViewModelProviders.of(this).get(
            PageViewModel::
            class.java
        )
        adapter = menuRowAdapter(pageViewModel,activity!!, datavar )

        view.recycelView_menu_row.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }


}






