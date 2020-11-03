package com.mridx.pdflibrary.UI.Recycler

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.department_recycler.*
import kotlinx.android.synthetic.main.department_recycler.view.*


class SubjectActivity : AppCompatActivity() {
    var recview: RecyclerView? = null
    var adapter: SubjectAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.department_recycler)

        recview = findViewById<View>(R.id.department_recycler_view) as RecyclerView
        recview!!.layoutManager = LinearLayoutManager(this)
        val options: FirebaseRecyclerOptions<SubjectData> = FirebaseRecyclerOptions.Builder<SubjectData>()
            .setQuery(
                FirebaseDatabase.getInstance().reference.child("Subject"),
                SubjectData::class.java
            )
            .build()
        adapter = SubjectAdapter(this, options).also {
            it.onDataChanged = this@SubjectActivity::onDataChanged
        }

        recview!!.adapter = adapter
        swipeRefresh.setOnRefreshListener {
            adapter!!.notifyDataSetChanged()
            swipeRefresh.isRefreshing = false
        }
    }
    private fun onDataChanged(b: Boolean){
        progressBar.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter?.stopListening()
    }

}

