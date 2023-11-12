package com.example.productrecyclerapp.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.productrecyclerapp.R
import com.example.productrecyclerapp.models.ProductDetailsModel
import java.text.DecimalFormat

class ProductDetailsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val bundle = intent.extras
        var productObj: ProductDetailsModel? = null
        if (bundle != null) {
            productObj = bundle.getSerializable("PRODUCT_OBJECT") as ProductDetailsModel?
        }
        var productImageView = findViewById<ImageView>(R.id.productImageView)
        var productLogoView = findViewById<ImageView>(R.id.productLogoView)
        var productPriceTxt = findViewById<TextView>(R.id.productPriceTxt)
        var productDescTxt = findViewById<TextView>(R.id.productDescriptionTxt)
        var productNameTxt = findViewById<TextView>(R.id.productName)
        var homeBtn = findViewById<Button>(R.id.homeBtn)

        productImageView.setImageResource(productObj?.productImage!!)
        productLogoView.setImageResource(productObj?.productLogo!!)

        val decimalFormat = DecimalFormat("#.##")
        val priceStr = "$" + decimalFormat.format(productObj?.productPrice)

        productNameTxt.setText(productObj?.productName.toString())
        productDescTxt.setText(productObj?.productDescription.toString())
        productPriceTxt.setText(priceStr)

        homeBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}