package com.example.week4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val image = findViewById<ImageView>(R.id.detailImage)
        val title = findViewById<TextView>(R.id.detailTitle)
        val price = findViewById<TextView>(R.id.detailPrice)

        val imgRes = intent.getIntExtra("image", 0)
        val titleText = intent.getStringExtra("title")
        val priceText = intent.getStringExtra("price")

        image.setImageResource(imgRes)
        title.text = titleText
        price.text = priceText
    }
}