package com.badri.recylerviewapiintegraion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.badri.recylerviewapiintegraion.Adapters.RecyclerviewAdapter
import com.badri.recylerviewapiintegraion.databinding.ActivityMainBinding
import com.badri.recylerviewapiintegraion.networking.ApiConfig.getData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerviewAdapter: RecyclerviewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        setUpRecyclerView()

        getData(this) { data ->
            Log.i("Data_fetched_from_api:", "$data")
            recyclerviewAdapter.submitList(data)
        }
    }

    private fun setUpRecyclerView() {
        recyclerviewAdapter = RecyclerviewAdapter()
        binding.rvData.apply {
            adapter = recyclerviewAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}