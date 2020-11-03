package com.mridx.pdflibrary.UI.Recycler

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.mridx.pdflibrary.R
import com.mridx.pdflibrary.UI.RecyclerPdfList.PdfListActivity
import kotlinx.android.synthetic.main.department_recycler.view.*
import kotlinx.android.synthetic.main.item.view.*
import javax.security.auth.Subject

class SubjectAdapter(private val context: Context, options: FirebaseRecyclerOptions<SubjectData>) : FirebaseRecyclerAdapter<SubjectData, SubjectAdapter.MyViewholder>(
    options
)
{
    var onDataChanged: ((b: Boolean) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewholder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewholder,
        position: Int,
        model: SubjectData
    ) {
        holder.subjectName.text = model.subjectName
        Glide.with(holder.subjectImage.context).load(model.subjectImage).into(holder.subjectImage)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PdfListActivity::class.java)
            intent.putExtra("subjectName", model.subjectName)
            context.startActivity(intent)
        }
    }

    class MyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val subjectName:TextView = itemView.findViewById(R.id.subjectName)
            val subjectImage: ImageView = itemView.findViewById(R.id.subjectImage)
    }

    override fun onDataChanged() {
        super.onDataChanged()
        onDataChanged?.invoke(true)
    }
}

