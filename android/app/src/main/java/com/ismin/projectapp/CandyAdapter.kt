package com.ismin.projectapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CandyAdapter(
    private val candies: ArrayList<Candy>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<CandyAdapter.CandyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandyViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_candy, parent, false)
        return CandyViewHolder(row)
    }

    override fun onBindViewHolder(holder: CandyViewHolder, position: Int) {
        val name = this.candies[position].competitorname

        holder.txvName.text = name
    }

    override fun getItemCount(): Int {
        return this.candies.size
    }

    fun updateItem(candiesToDisplay: List<Candy>) {
        candies.clear();
        candies.addAll(candiesToDisplay)
        notifyDataSetChanged();
    }

    inner class CandyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var txvName = itemView.findViewById<TextView>(R.id.r_candy_txv_comptetitorname)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position : Int = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}
