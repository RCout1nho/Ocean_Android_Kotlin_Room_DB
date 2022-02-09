package com.example.ocean_android_kotlin_room_db.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.ocean_android_kotlin_room_db.R
import com.example.ocean_android_kotlin_room_db.model.ProductEntity
import com.example.ocean_android_kotlin_room_db.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etProduct = findViewById<TextView>(R.id.etProduct)
        val btAddProduct = findViewById<TextView>(R.id.btAddProduct)
        val tvProductName = findViewById<TextView>(R.id.tvProductName)

        val productViewModel: ProductViewModel =
            ViewModelProvider(this).get(ProductViewModel::class.java)

        productViewModel.products.observe(
            this
        ) {
            tvProductName.text = "Produtos: "
            it.forEach { product ->
                tvProductName.append("${product.nome}\n")
            }
        }

        btAddProduct.setOnClickListener{
            val newProduct = ProductEntity(null, etProduct.text.toString(), null)
            productViewModel.create(newProduct)

        }

    }
}