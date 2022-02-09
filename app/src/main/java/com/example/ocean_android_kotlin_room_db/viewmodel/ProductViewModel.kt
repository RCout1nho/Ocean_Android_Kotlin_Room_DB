package com.example.ocean_android_kotlin_room_db.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ocean_android_kotlin_room_db.model.AppDatabase
import com.example.ocean_android_kotlin_room_db.model.ProductDao
import com.example.ocean_android_kotlin_room_db.model.ProductEntity

class ProductViewModel(application: Application): AndroidViewModel(application) {
    private val productDao: ProductDao
    val products: LiveData<List<ProductEntity>>

    init {
        val db = AppDatabase.getDatabase(application) // db é criado
        productDao = db.productDao()


        products = productDao.selectAll()
    }

    fun create(product: ProductEntity){
        Thread{
            productDao.create(product)
        }.start()

    }


}