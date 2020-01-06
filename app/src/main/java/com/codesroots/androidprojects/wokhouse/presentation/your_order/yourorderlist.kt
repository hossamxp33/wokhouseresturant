package com.codesroots.androidprojects.wokhouse.presentation.your_order

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.codesroots.androidprojects.wokhouse.R
import kotlinx.android.synthetic.main.item_detail.*
import kotlinx.android.synthetic.main.your_order.*

class Yourorderlist:AppCompatActivity() {

 //   lateinit var adapter: ShoppingCartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.your_order)
         var value1 = integer_number


      //  setSupportActionBar(toolbar)

//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        val upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material)
//        upArrow?.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP)
//        supportActionBar?.setHomeAsUpIndicator(upArrow)
//
//
//        adapter = ShoppingCartAdapter(this, ShoppingCart.getCart())
//        adapter.notifyDataSetChanged()
//
//        shopping_cart_recyclerView.adapter = adapter
//
//        shopping_cart_recyclerView.layoutManager = LinearLayoutManager(this)
//

//        var totalPrice = ShoppingCart.getCart()
//            .fold(0.toDouble()) { acc, cartItem -> acc + cartItem.quantity.times(cartItem.product.price!!.toDouble()) }
//
//

        var totalPrice = textPrice
       total_price.text = "$${totalPrice}"


    }



}
