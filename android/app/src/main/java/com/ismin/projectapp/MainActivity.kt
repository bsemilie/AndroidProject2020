package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() /**,CandyAdapter.OnItemClickListener**/ {
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
        image = "https://cdn.shopify.com/s/files/1/0972/7116/products/all-city-candy-3-musketeers-candy-bar-192-oz-candy-bars-mars-chocolate-1-bar-211310_600x.jpg?v=1557238040"
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
        image = "https://st.depositphotos.com/2193716/4046/i/950/depositphotos_40460565-stock-photo-american-one-quarter-coin.jpg"
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
        image = "https://st.depositphotos.com/2193716/4046/i/950/depositphotos_40460565-stock-photo-american-one-quarter-coin.jpg"
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
        image ="https://www.myamericanmarket.com/6103-large_default/airheads-blue-raspberry-taffy-candy.jpg"
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
        displayList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_action_refresh -> {
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, "That's refreshing", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun displayList() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val candyListFragment = CandyListFragment.newInstance(this.candyshelf.getAllCandies())

        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, candyListFragment)
        fragmentTransaction.commit()
    }
    fun goToList(view: View) {
        displayList()
    }

    private fun displayAbout() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val aboutFragment = AboutFragment.newInstance()

        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, aboutFragment)
        fragmentTransaction.commit()
    }

    fun goToAbout(view: View) {
        displayAbout()
    }

}