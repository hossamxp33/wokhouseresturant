package com.codesroots.androidprojects.wokhouse.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class CategoryModel (
    val data: List<CategoryData>? = null
)

    : Parcelable {

}
@Parcelize

data class CategoryData (
    val id: Int? = null,
    val name: String? = null,
    val created: String? = null,
    val modified: String? = null,
    val type: String? = null,
    val photo: String? = null,

    val subcategories: List<Subcategory>? = null
):Parcelable {

}


@Parcelize
data class Subcategory (
    val id: Int? = null,
    val name: String? = null,
    val categoryID: Long? = null,
    val created: String? = null,
    val modified: String? = null,
    val photo: String? = null

):Parcelable {

}
