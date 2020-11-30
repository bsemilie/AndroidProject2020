package com.ismin.projectapp

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

    private lateinit var rcvCandies: RecyclerView
    private lateinit var candyAdapter: CandyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        candyshelf = arguments!!.getSerializable("candies") as ArrayList<Candy>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_candy_list, container, false)

        this.rcvCandies = rootView.findViewById(R.id.a_rcv_candies)
        candyAdapter = CandyAdapter(candyshelf,this)
        this.rcvCandies.adapter = candyAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvCandies.layoutManager = linearLayoutManager


        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvCandies.addItemDecoration(dividerItemDecoration)

        return rootView
    }

    override fun onItemClick(position: Int) {
        val candy : Candy = candyshelf[position]
        Toast.makeText(context, "Item ${candy.competitorname} clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("candy",candy)
        this.startActivity(intent)
    }

    companion object {
        @JvmStatic
        fun newInstance(candyshelf: ArrayList<Candy>): CandyListFragment {
            val bundle = Bundle()
            bundle.putSerializable("candies", candyshelf)

            val candyListFragment = CandyListFragment()
            candyListFragment.arguments = bundle

            return candyListFragment;
        }
    }
}