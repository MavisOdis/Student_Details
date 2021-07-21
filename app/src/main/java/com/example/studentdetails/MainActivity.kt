package com.example.studentdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentdetails.databinding.ActivityMainBinding
import com.example.studentdetails.ui.MainViewModel
import com.example.studentdetails.ui.StudentAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var  viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentAdapter = StudentAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.itemRv.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.btnGetItems.setOnClickListener {
            viewModel.run {
                getItem()
                itemLiveData.observe(this@MainActivity, { items ->
                    studentAdapter.details = items
                    studentAdapter.notifyDataSetChanged()
                })
            }
        }
    }
}