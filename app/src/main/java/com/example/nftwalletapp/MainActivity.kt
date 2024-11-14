package com.example.nftwalletapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var nftRecyclerView: RecyclerView
    private lateinit var nftAdapter: NFTAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nftRecyclerView = findViewById(R.id.nftRecyclerView)
        nftRecyclerView.layoutManager = LinearLayoutManager(this)

        val nfts = getNFTs("user_wallet_address")
        nftAdapter = NFTAdapter(nfts)
        nftRecyclerView.adapter = nftAdapter

        findViewById<Button>(R.id.walletConnectButton).setOnClickListener {
            startActivity(Intent(this, WalletConnectActivity::class.java))
        }
    }

    private fun getNFTs(walletAddress: String): List<NFT> {
        // Kode pengambilan NFT dari blockchain
        return listOf(
            NFT("1", "NFT Name", "Description", "https://image.url"),
            // Tambahkan data NFT lainnya
        )
    }
}
