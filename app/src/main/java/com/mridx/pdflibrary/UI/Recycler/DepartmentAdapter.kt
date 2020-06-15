package com.mridx.pdflibrary.UI.Recycler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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

class DepartmentAdapter(val context: Context, private val departmentList: ArrayList<DepartmentData>) :
    RecyclerView.Adapter<DepartmentAdapter.Viewholder>() {

    class Viewholder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
        var currentItem: DepartmentData? = null
        var currentPosition: Int = 0
        init {
            itemView.setOnClickListener {
                Toast.makeText(context, "Department $currentPosition", Toast.LENGTH_SHORT).show()
            }
        }
        fun setData(departmentData: DepartmentData?, position: Int){
            itemView.txtDepartment.text = departmentData!!.departmentName
            this.currentItem = departmentData
            this.currentPosition = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Viewholder(view, context)
    }

    override fun getItemCount() = departmentList.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val items: DepartmentData = departmentList[position]
        holder.setData(items, position)
        }

}