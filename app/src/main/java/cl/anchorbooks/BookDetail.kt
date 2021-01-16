package cl.anchorbooks

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_detail")
data class BookDetail(@PrimaryKey val id: Int, val author: String, val country: String, val imageLink: String, val language: String, val link: String, val pages: Int, val title: String, val year: Int, val price: Int, val lastPrice: Int, val delivery: Boolean)