package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CandyAdapter.OnItemClickListener {
    private val c1 = Candy(
        bar = 1,
        caramel = 1,
        chocolate = 1,
        competitorname = "100 grand",
        crispedricewafer = 1,
        fruity = 0,
        hard = 0,
        nougat = 0,
        peanutyalmondy = 0,
        pluribus = 0,
        pricepercent = 0.86000001,
        sugarpercent = 0.73199999,
        winpercent = 66.971725,
        image = "https://storage.googleapis.com/products.ezadtv.com/2211/206848.jpeg"
    )
    private val c2 = Candy(
        bar = 1,
        caramel = 0,
        chocolate = 1,
        competitorname = "3 musketeers",
        crispedricewafer = 0,
        fruity = 0,
        hard = 0,
        nougat = 1,
        peanutyalmondy = 0,
        pluribus = 0,
        pricepercent = 0.51099998,
        sugarpercent = 0.60399997,
        winpercent = 67.602936,
        image = "https://www.meijer.com/content/dam/meijer/product/0004/00/0042/20/0004000042208_4_A1C1_1200.png"
    )
    private val c3 = Candy(
        bar = 0,
        caramel = 0,
        chocolate = 0,
        competitorname = "one dime",
        crispedricewafer = 0,
        fruity = 0,
        hard = 0,
        nougat = 0,
        peanutyalmondy = 0,
        pluribus = 0,
        pricepercent = 0.116,
        sugarpercent = 0.011,
        winpercent = 32.261086,
        image = "https://lh3.googleusercontent.com/proxy/Yl_0U7HIjk0V_AbRAYOv6OKfx9bAC0L3tKoUwLYszEyO4bBOosvfcxDLcbANQlRdUnAllwgUJ-gJN8Bh8lKS8Ed9fTfdyB_So687Poya69bgsjiscCu84TiG7iSiPMeJn6ih0jurYtbf-SGIoqd9pVbLsnm9lHz5Gy9-C7I8eU_80qMGcfyKNZ8"
    )
    private val c4 = Candy(
        bar = 0,
        caramel = 0,
        chocolate = 0,
        competitorname = "one quarter",
        crispedricewafer = 0,
        fruity = 0,
        hard = 0,
        nougat = 0,
        peanutyalmondy = 0,
        pluribus = 0,
        pricepercent = 0.51099998,
        sugarpercent = 0.011,
        winpercent = 46.116505,
        image = "https://st.depositphotos.com/2193716/4046/i/950/depositphotos_40460565-stock-photo-american-one-quarter-coin.jp"
    )
    private val c5 = Candy(
        bar = 0,
        caramel = 0,
        chocolate = 0,
        competitorname = "air heads",
        crispedricewafer = 0,
        fruity = 1,
        hard = 0,
        nougat = 0,
        peanutyalmondy = 0,
        pluribus = 0,
        pricepercent = 0.51099998,
        sugarpercent = 0.90600002,
        winpercent = 52.341465,
        image = "image\":\"https://www.myamericanmarket.com/6103-large_default/airheads-blue-raspberry-taffy-candy.jpg"
    )

    private val candyshelf= CandyShelf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.candyshelf.addCandy(c1)
        this.candyshelf.addCandy(c2)
        this.candyshelf.addCandy(c3)
        this.candyshelf.addCandy(c4)
        this.candyshelf.addCandy(c5)


        val recyclerView = findViewById<RecyclerView>(R.id.a_rcv_candies)
        val adapter = CandyAdapter(candyshelf.getAllCandies(),this)
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    }

    override fun onItemClick(position: Int) {
        val candy : Candy = candyshelf.getAllCandies()[position]
        Toast.makeText(this, "Item ${candy.competitorname} clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("candy",candy)
        this.startActivity(intent)
    }


}