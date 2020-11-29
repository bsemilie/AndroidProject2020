package com.ismin.projectapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val candy = intent.getSerializableExtra("candy") as Candy

        var imageView=findViewById<ImageView>(R.id.imageView)
        Picasso.get().load(candy.image).into(imageView)

        var nameTextView =findViewById<TextView>(R.id.name)
        nameTextView.text = candy?.competitorname

    }
}