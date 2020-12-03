package com.ismin.projectapp

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CandyListFragment : Fragment(), CandyAdapter.OnItemClickListener {
    private lateinit var candyshelf: ArrayList<Candy>
    private var favShelf = arrayListOf<String>()
    private lateinit var rcvCandies: RecyclerView
    private lateinit var candyAdapter: CandyAdapter

    private var listener: CandyListListener? = null

    interface CandyListListener {
        fun favFromFragment(name: String)
        fun refreshPostDetail()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CandyListListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement MyActivityCallback")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        candyshelf = arguments!!.getSerializable("candies") as ArrayList<Candy>
        favShelf = arguments!!.getSerializable("favs") as ArrayList<String>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_candy_list, container, false)

        this.rcvCandies = rootView.findViewById(R.id.a_rcv_candies)
        candyAdapter = CandyAdapter(candyshelf, favShelf, this)
        this.rcvCandies.adapter = candyAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvCandies.layoutManager = linearLayoutManager


        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvCandies.addItemDecoration(dividerItemDecoration)

        return rootView
    }


    override fun onItemClick(position: Int) {
        val candy: Candy = candyshelf[position]
        Toast.makeText(context, "Item ${candy.competitorname} clicked", Toast.LENGTH_SHORT).show()

        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("candy", candy)
        intent.putExtra("fav", favShelf.contains(candy.competitorname))
        this.startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            var newfav = data?.getBooleanExtra("fav", false)
            var name = data?.getStringExtra("candyname")
            if (name != null) {
                if (newfav!!) {
                    if (!favShelf.contains(name)) {
                        favShelf.add(name)
                    }
                } else {
                    if (favShelf.contains(name)) {
                        favShelf.remove(name)
                    }
                }
                listener?.refreshPostDetail()
            }
        }
    }

    override fun favFromAdapter(position: Int) {
        val candy: Candy = candyshelf[position]
        Toast.makeText(context, "Item ${candy.competitorname} faved", Toast.LENGTH_SHORT).show()
        if (favShelf.contains(candy.competitorname)) {
            favShelf.remove(candy.competitorname)
        } else {
            favShelf.add(candy.competitorname)
        }
        listener?.favFromFragment(candy.competitorname)
    }

    companion object {
        @JvmStatic
        fun newInstance(candyshelf: ArrayList<Candy>, favs: ArrayList<String>): CandyListFragment {
            val bundle = Bundle()
            bundle.putSerializable("candies", candyshelf)
            bundle.putStringArrayList("favs", favs)

            val candyListFragment = CandyListFragment()
            candyListFragment.arguments = bundle
            return candyListFragment;
        }
    }
}