package com.example.myrvexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myrvexample.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val TRADE_ID = "trade_id"
        const val STOCK_SYMBOL = "stock_symbol"
        const val PURCHASE_PRICE = "purchase_price"
        const val SALE_PRICE = "sale_price"
        const val TRADE_DATE = "trade_date"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        // Retrieve stock details from intent extras
        val tradeId = intent.getStringExtra(TRADE_ID)
        val stockSymbol = intent.getStringExtra(STOCK_SYMBOL)
        val purchasePrice = intent.getDoubleExtra(PURCHASE_PRICE, 0.0)
        val salePrice = intent.getDoubleExtra(SALE_PRICE, 0.0)
        val tradeDate = intent.getStringExtra(TRADE_DATE)

        // Bind data to views
        binding.tradeIdView.text = tradeId
        binding.stockSymbolView.text = stockSymbol
        binding.purchasePriceView.text = purchasePrice.toString()
        binding.salePriceView.text = salePrice.toString()
        binding.tradeDateView.text = tradeDate

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
