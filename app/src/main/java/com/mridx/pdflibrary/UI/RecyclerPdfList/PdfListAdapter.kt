package com.mridx.pdflibrary.UI.RecyclerPdfList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mridx.pdflibrary.R
import com.mridx.pdflibrary.UI.PdfViewActivity
import kotlinx.android.synthetic.main.pdfitem.view.*

class PdfListAdapter(private val context: Context, private val pdfList: ArrayList<PdfListData>):
    RecyclerView.Adapter<PdfListAdapter.myViewHolder>() {

    var onItemClicked: ((PdfListData) -> Unit)? = null

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.pdfitem, parent, false)
       return myViewHolder(view)
    }

    override fun getItemCount() = pdfList.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val myList: PdfListData = pdfList[position]
        holder.itemView.txtPdfName.text = myList.pdfName
        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(pdfList[position])
            val intent = Intent(context, PdfViewActivity::class.java)
            intent.putExtra("pdfName", myList.pdfName)
            context.startActivity(intent)
        }
     }

}