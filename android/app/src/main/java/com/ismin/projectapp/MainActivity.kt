package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), CandyListFragment.CandyListListener {

    private lateinit var candyService: CandyService
    private val candyshelf = CandyShelf()
    private var favShelf = arrayListOf<String>()
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = intent.getStringExtra(Intent.EXTRA_TEXT)!!
        Toast.makeText(this, "Welcome ${username}!", Toast.LENGTH_SHORT).show()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SERVER_BASE_URL)
            .build()

        candyService = retrofit.create(CandyService::class.java)

        /**
         * Tu peux faire la récup des données de l'user ici (avant de create la liste)
         * T'as juste à remplir les favoris de l'user dans favshelf
         * Je n'utilise que le competitorname
         *
         * Tu peux envoyer la liste sur clevercloud a la fin des fonctions:
         * favFromFragment et refreshPostDetail, en fin du fichier
         **/

        createList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_action_refresh -> {
                Toast.makeText(this, "That's refreshing", Toast.LENGTH_SHORT).show()
                createList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun createList() {
        candyService.getCandyBars().enqueue(object : Callback<ArrayList<Candy>> {
            override fun onResponse(
                call: Call<ArrayList<Candy>>,
                response: Response<ArrayList<Candy>>
            ) {
                val allCandy = response.body()
                allCandy?.forEach {
                    candyshelf.addCandy(it)
                }
                displayList()
            }

            override fun onFailure(call: Call<ArrayList<Candy>>, t: Throwable) {
                displayErrorToast(t)
            }
        })
    }

    private fun displayList() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val candyListFragment =
            CandyListFragment.newInstance(this.candyshelf.getAllCandies(), favShelf)

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


    companion object {
        const val SERVER_BASE_URL = "https://candyshop.cleverapps.io/"
    }

    private fun displayErrorToast(t: Throwable) {
        Toast.makeText(applicationContext, "Network error ${t.localizedMessage}", Toast.LENGTH_LONG)
            .show()
    }

    override fun favFromFragment(name: String) {
        if (favShelf.contains(name)) {
            Toast.makeText(this, "Removing ${name}", Toast.LENGTH_SHORT).show()
            favShelf.remove(name)
        } else {
            Toast.makeText(this, "Adding ${name}", Toast.LENGTH_SHORT).show()
            favShelf.add(name)
        }
    }

    override fun refreshPostDetail() {
        createList()
    }

}