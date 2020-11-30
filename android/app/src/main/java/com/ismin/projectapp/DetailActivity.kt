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
        nameTextView.text = "Name: ${candy.competitorname.toString()}"


        findViewById<TextView>(R.id.bar).text = "Bar: ${candy.bar.toString()}"
        findViewById<TextView>(R.id.caramel).text = "Caramel: ${candy.caramel.toString()}"
        findViewById<TextView>(R.id.chocolate).text = "Chocolate: ${candy.chocolate.toString()}"
        findViewById<TextView>(R.id.crispedricewafer).text = "Crisped Rice Wafer: ${candy.crispedricewafer.toString()}"
        findViewById<TextView>(R.id.fruity).text = "Fruity: ${candy.fruity.toString()}"
        findViewById<TextView>(R.id.hard).text = "Hard: ${candy.hard.toString()}"
        findViewById<TextView>(R.id.nougat).text = "Nougat: ${candy.nougat.toString()}"
        findViewById<TextView>(R.id.peanutyalmondy).text = "Peanuty or Almondy: ${candy.peanutyalmondy.toString()}"
        findViewById<TextView>(R.id.pluribus).text = "Bar: ${candy.pluribus.toString()}"

    }
}