package com.mridx.pdflibrary.UI.Recycler

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mridx.pdflibrary.R
import com.mridx.pdflibrary.UI.PdfActivity
import kotlinx.android.synthetic.main.item.view.*

class DepartmentAdapter(context: Context, private val pdfList: ArrayList<DepartmentData>) :
    RecyclerView.Adapter<DepartmentAdapter.myViewHolder>() {

    private val context: Context? = context
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
            val intent = Intent(context, PdfActivity::class.java)
            context?.startActivity(intent)
            Toast.makeText(context, items.departmentName, Toast.LENGTH_SHORT).show()
        }
    }
}