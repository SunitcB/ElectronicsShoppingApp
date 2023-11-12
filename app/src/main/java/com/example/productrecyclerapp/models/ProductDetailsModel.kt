package com.example.productrecyclerapp.models

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.math.BigDecimal

class ProductDetailsModel(
    val productName: String?,
    val productDescription: String?,
    val productPrice: Float,
    val productLogo: Int,
    val productImage: Int
) : Serializable