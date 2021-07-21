package com.example.studentdetails.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdetails.databinding.ItemListBinding
import com.example.studentdetails.models.Detail

class StudentAdapter(var details: List<Detail>):
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(private var binding: ItemListBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(detail: Detail){
                binding.apply {
                    txId.text = detail.id.toString()
                    txName.text = detail.name
                    txPrice.text = detail.price.toString()

                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return StudentViewHolder((binding))
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(details[position])
    }

    override fun getItemCount(): Int {
        return details.size
    }
}