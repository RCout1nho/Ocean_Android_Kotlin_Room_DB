package com.example.ocean_android_kotlin_room_db.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    // Create
    @Insert
    fun create(product: ProductEntity)

    // Read
    @Query("SELECT * FROM products")
    fun selectAll(): LiveData<List<ProductEntity>>
}