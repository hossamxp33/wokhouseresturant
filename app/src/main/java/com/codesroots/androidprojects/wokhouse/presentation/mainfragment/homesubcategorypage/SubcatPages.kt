package com.codesroots.androidprojects.wokhouse.presentation.mainfragment.homesubcategorypage


import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.codesroots.androidprojects.wokhouse.R
import com.codesroots.androidprojects.wokhouse.model.ItemsModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.subcategory_items.*
import okhttp3.*
import java.io.IOException
import android.widget.RatingBar




class SubcatPages: AppCompatActivity() {

    var  data : ItemsModel? = null
    var name : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subcategory_items)

        var extras = intent.extras
        val value = extras!!.getInt("id")

        name = extras!!.getString("name")
        setTitle(name)


        getItems(value)
        subCategoryRecycle.layoutManager = GridLayoutManager(applicationContext,2)




    }


    private  fun getItems(id:Int){
        val url = "http://wokhouse.codesroots.com/api/items/getitemsbytype/"+id+"/1.json"
        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val  body = response.body?.string()
                println(body)


                val gson = GsonBuilder().create()
                val items = Gson().fromJson(body, ItemsModel::class.java)

                data = items

                runOnUiThread {

                    subCategoryRecycle.adapter =
                        subcategoryAdapter(
                            items,
                            this@SubcatPages
                        )
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")

            }


        })
    }

}
