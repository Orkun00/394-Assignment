package com.example.myrvexample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrvexample.R
import com.example.myrvexample.UserDetailActivity
import com.example.myrvexample.model.User

class ItemAdapter(private val data: List<User>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var user: User
        val tradeIdTextView: TextView = view.findViewById(R.id.tradeIdTextView)
        val stockSymbolTextView: TextView = view.findViewById(R.id.stockSymbolTextView)
        val purchasePriceTextView: TextView = view.findViewById(R.id.purchasePriceTextView)
        val salePriceTextView: TextView = view.findViewById(R.id.salePriceTextView)
        val tradeDateTextView: TextView = view.findViewById(R.id.tradeDateTextView)

        init {
            view.setOnClickListener {
                val context = itemView.context
                val detailIntent = Intent(context, UserDetailActivity::class.java)

                // Pass stock details as Intent extras
                detailIntent.putExtra("trade_id", user.trade_id)
                detailIntent.putExtra("stock_symbol", user.stock_symbol)
                detailIntent.putExtra("purchase_price", user.purchase_price)
                detailIntent.putExtra("sale_price", user.sale_price)
                detailIntent.putExtra("trade_date", user.trade_date)

                context.startActivity(detailIntent)
            }
        }

        fun bind(user: User) {
            this.user = user
            tradeIdTextView.text = user.trade_id
            stockSymbolTextView.text = user.stock_symbol
            purchasePriceTextView.text = user.purchase_price.toString()
            salePriceTextView.text = user.sale_price.toString()
            tradeDateTextView.text = user.trade_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)
    }
}
