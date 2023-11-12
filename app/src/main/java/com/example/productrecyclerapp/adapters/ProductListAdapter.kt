package com.example.productrecyclerapp.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.productrecyclerapp.R
import com.example.productrecyclerapp.activities.ProductDetailsActivity
import com.example.productrecyclerapp.models.ProductDetailsModel
import java.text.DecimalFormat

class ProductListAdapter(
    private val context: Context,
    private val productList: List<ProductDetailsModel>
) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.productCardView)
        val productLogoView = itemView.findViewById<ImageView>(R.id.productImageView)
        val productImageView = itemView.findViewById<ImageView>(R.id.productLogoView)
        val productNameView = itemView.findViewById<TextView>(R.id.productNameView)
        val productDescriptionView = itemView.findViewById<TextView>(R.id.productDescriptionView)
        val productPriceView = itemView.findViewById<TextView>(R.id.productPriceView)
        val addToCartBtn = itemView.findViewById<Button>(R.id.addToCartBtn)
    }

    var cartItemList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var productObj = productList[position]
        holder.productNameView.text = productObj.productName
        var productDesc = productObj.productDescription.toString()
        if (productObj.productDescription.toString().length > 150) {
            productDesc = productDesc.substring(0, 150) + "..."
        }
        holder.productDescriptionView.text = productDesc
        holder.productImageView.setImageResource(productObj.productImage)
        holder.productLogoView.setBackgroundResource(R.drawable.ic_launcher_background)
        holder.productLogoView.setImageResource(productObj.productLogo)
        val decimalFormat = DecimalFormat("#.##")
        val priceStr = "$" + decimalFormat.format(productObj?.productPrice)
        holder.productPriceView.text = priceStr

        holder.cardView.setOnClickListener {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("PRODUCT_OBJECT", productObj)
            intent.putExtras(bundle)
            startActivity(context, intent, null)
        }

        holder.addToCartBtn.setOnClickListener {
            cartItemList.add(productObj.productName.toString())
            Toast.makeText(context, "${productObj.productName} added to cart", Toast.LENGTH_SHORT)
                .show()
        }
    }
}