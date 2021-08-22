package com.mobile.azri.hiltmvvmexample.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.azri.hiltmvvmexample.R
import com.mobile.azri.hiltmvvmexample.databinding.ActivityMainBinding
import com.mobile.azri.hiltmvvmexample.model.RecyclerData
import com.mobile.azri.hiltmvvmexample.view.adapter.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    //ini bisa dijadiin depedency
    private lateinit var recyclerAdapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView(){
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerAdapter = RecyclerAdapter()
            adapter = recyclerAdapter
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this,{
            if (it!=null){
                recyclerAdapter.setListData(it as ArrayList<RecyclerData>)
                recyclerAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Data is NULL",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.loadListOfData()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}