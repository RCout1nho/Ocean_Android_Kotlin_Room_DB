package com.example.ocean_android_kotlin_room_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: Long?,

    val nome: String,

    val imageUrl: String?
)
