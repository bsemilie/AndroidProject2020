package com.ismin.projectapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CandyAdapter(
    private val candies: ArrayList<Candy>, private val favshelf :ArrayList<String>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<CandyAdapter.CandyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandyViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_candy, parent, false)
        return CandyViewHolder(row)
    }

    override fun onBindViewHolder(holder: CandyViewHolder, position: Int) {
        val name = this.candies[position].competitorname
        if(favshelf.contains(name)){
            holder.buttonFav.setImageResource(R.drawable.ic_baseline_star_24)
        }
        else{
            holder.buttonFav.setImageResource(R.drawable.ic_baseline_star_border_24)
        }
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
        val buttonFav = itemView.findViewById<ImageButton>(R.id.imageButtonFav)

        init {
            itemView.setOnClickListener(this)
            buttonFav.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when (v) {
                buttonFav -> {
                    if(favshelf.contains(txvName.text)){
                        buttonFav.setImageResource(R.drawable.ic_baseline_star_border_24)
                        favshelf.remove(txvName.text)
                        listener.favFromAdapter(adapterPosition)

                    }else{
                        buttonFav.setImageResource(R.drawable.ic_baseline_star_24)
                        favshelf.add(txvName.text as String)
                        listener.favFromAdapter(adapterPosition)
                    }
                }
                else -> {
                    val position: Int = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun favFromAdapter(position : Int)
    }

}
