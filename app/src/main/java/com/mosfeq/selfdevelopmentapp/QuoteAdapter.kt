package com.mosfeq.selfdevelopmentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quote_item.view.*

class QuoteAdapter(
    private val listOfQuotes: List<QuoteItem>
): RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.quote_item, parent, false)

        return QuoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val currentQuoteItem = listOfQuotes[position]

        holder.quoteText.text = currentQuoteItem.quoteText
        holder.quoteAuthor.text = currentQuoteItem.quoteAuthor
    }

    override fun getItemCount(): Int {
        return listOfQuotes.size
    }

    class QuoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val quoteText: TextView = itemView.tv_quote
        val quoteAuthor: TextView = itemView.tv_quoteAuthor
    }

}