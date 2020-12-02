package com.ismin.projectapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {
    private var fav : Boolean = false
    private lateinit var candy : Candy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        candy = intent.getSerializableExtra("candy") as Candy

        fav= intent.getBooleanExtra("fav",false)

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

        if(fav){
            findViewById<ImageButton>(R.id.imageButton).setImageResource(R.drawable.ic_baseline_star_24)
        }

    }

    fun favButton(view: View) {
        val imgBttn= findViewById<ImageButton>(R.id.imageButton)
        if(fav){
            imgBttn.setImageResource(R.drawable.ic_baseline_star_border_24)
            fav = !fav
        }else{
            imgBttn.setImageResource(R.drawable.ic_baseline_star_24)
            fav = !fav
        }
    }

    override fun onBackPressed() {
        val returnIntent = Intent()
        returnIntent.putExtra("fav", fav)
        returnIntent.putExtra("candyname",candy.competitorname )
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
        super.onBackPressed()
    }

}