package com.example.productrecyclerapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productrecyclerapp.R
import com.example.productrecyclerapp.adapters.ProductListAdapter
import com.example.productrecyclerapp.models.ProductDetailsModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val productList = mutableListOf<ProductDetailsModel>(
        ProductDetailsModel(
            "Apple iPad Pro (12.9-inch, 6th generation)",
            "The 2021 models had a vast range of reviews feeling that the already powerful processor was made excessively powerful, stating that the processor wasn't being taken advantage of due to iPadOS still being considered too limiting and not having professional apps from macOS.[63][64] Camera placement has been criticized for video conferencing.[65] The Verge has criticized that they should have had multiuser support like the Mac but they gave positive reviews to the Mini-LED and cameras.",
            749.99f,
            R.mipmap.ic_apple_logo,
            R.mipmap.ic_ipad_foreground
        ),
        ProductDetailsModel(
            "Apple iPhone 15 Pro",
            "The iPhone 15 Pro and iPhone 15 Pro Max are Apple's current high-end flagship iPhones, sold alongside the iPhone 15 and iPhone 15 Plus. The new models launched on Friday, September 22, which means now is the best time to buy an iPhone 15 Pro or iPhone 15 Pro Max.",
            1999.99f,
            R.mipmap.ic_apple_logo,
            R.mipmap.ic_iphone_foreground
        ),
        ProductDetailsModel(
            "Apple MacBook Pro M3 Pro",
            "The industry’s first 3-nanometer chips for a personal computer debut a next-generation GPU architecture and deliver dramatic performance improvements, a faster CPU and Neural Engine, and support for more unified memory",
            1199.99f,
            R.mipmap.ic_apple_logo,
            R.mipmap.ic_macbook_foreground
        ),
        ProductDetailsModel(
            "Dell Alienware x16",
            "Dell Alienware x16 is a Windows 11 laptop with a 16.00-inch display that has a resolution of 1600x2560 pixels. It is powered by a Core i9 processor and it comes with 32GB of RAM. The Dell Alienware x16 packs 4TB of SSD storage.\n" +
                    "\n" +
                    "Graphics are powered by Nvidia GeForce RTX 4090. Connectivity options include Bluetooth, Ethernet and it comes with 6 USB ports, USB 3.2 Gen 1 (Type A), USB 3.2 Gen 2 (Type C), Thunderbolt 4 (Type C), HDMI Port, Multi Card Slot, Headphone and Mic Combo Jack, RJ45 (LAN) ports.",
            1749.99f,
            R.mipmap.ic_dell,
            R.mipmap.ic_laptop_foreground
        ),
        ProductDetailsModel(
            "Logitech - K845 Full-size Wired Mechanical Cherry MX Blue Clicky Switch Keyboard with Five Backlight Modes - Graphite",
            "Type notes efficiently with this Logitech mechanical corded keyboard. The five backlighting options add impact to your gaming, while the solid anodized aluminum top and the sturdy mechanical switches offer dependable durability and satisfying feedback. This Logitech mechanical corded keyboard has a curved profile and tilt legs for comfortable use, and the 12 FN keys enable quick access to shortcuts for enhanced productivity.",
            67.99f,
            R.mipmap.ic_logitech,
            R.mipmap.ic_keyboard_foreground
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewCartBtn = findViewById<FloatingActionButton>(R.id.viewCartBtn)
        var recyclerView = findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productListAdapter = ProductListAdapter(this, productList)
        recyclerView.adapter = productListAdapter

        viewCartBtn.setOnClickListener {
            Toast.makeText(
                this,
                productListAdapter.cartItemList.joinToString(", "),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}