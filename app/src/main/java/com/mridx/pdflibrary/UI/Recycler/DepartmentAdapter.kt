package com.mridx.pdflibrary.UI.Recycler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.mridx.pdflibrary.R
import com.mridx.pdflibrary.UI.PdfActivity
import kotlinx.android.synthetic.main.item.view.*

class DepartmentAdapter(private val departmentList: ArrayList<DepartmentData>, private val listener:(DepartmentData) -> Unit) :
    RecyclerView.Adapter<DepartmentAdapter.Viewholder>() {
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.txtDepartment
        fun bind(items: DepartmentData){
            textView.text = items.departmentName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount() = departmentList.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val items: DepartmentData = departmentList[position]
        holder.textView.text = items.departmentName
        holder.bind(items)
        holder.itemView.setOnClickListener {
            listener(items)
        }
    }
}