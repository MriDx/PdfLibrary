package com.mridx.pdflibrary.UI.RecyclerPdfList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.pdfitem.view.*

class PdfListAdapter(private val context: Context, private val pdfList: ArrayList<PdfListData>):
    RecyclerView.Adapter<PdfListAdapter.myViewHolder>() {
    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.pdfitem, parent, false)
       return myViewHolder(view)
    }

    override fun getItemCount() = pdfList.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val myList: PdfListData = pdfList[position]
        holder.itemView.txtPdfName.text = myList.pdfName
     }

}