package com.mridx.pdflibrary.UI.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.item.view.*

class DepartmentAdapter(private val departmentList: ArrayList<DepartmentData>) :
    RecyclerView.Adapter<DepartmentAdapter.Viewholder>() {
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.txtDepartment
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount() = departmentList.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val items: DepartmentData = departmentList[position]
        holder.textView.text = items.departmentName
    }
}