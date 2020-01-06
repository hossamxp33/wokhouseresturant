package com.codesroots.androidprojects.wokhouse.presentation.your_order

import com.codesroots.androidprojects.wokhouse.model.ItemData

    data class CartItem(var product: ItemData, var quantity: Int = 0)
