package com.mridx.pdflibrary.UI.Recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.item.view.*

class DepartmentAdapter(context: Context, private val pdfList: ArrayList<DepartmentData>) :
    RecyclerView.Adapter<DepartmentAdapter.myViewHolder>() {

    var context: Context? = null
    var onItemClicked: ((DepartmentData) -> Unit)? = null

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount() = pdfList.size


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val items: DepartmentData = pdfList[position]
        holder.itemView.txtDepartment.text = items.departmentName
        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(pdfList[position])
            Log.d("test", "Position: $position")
        }
    }
}