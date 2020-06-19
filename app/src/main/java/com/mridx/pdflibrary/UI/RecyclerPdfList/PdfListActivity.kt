package com.mridx.pdflibrary.UI.RecyclerPdfList

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mridx.pdflibrary.R
import com.mridx.pdflibrary.UI.Recycler.DepartmentAdapter
import kotlinx.android.synthetic.main.pdflist.*

class PdfListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pdflist)
        val intent = intent
        setSupportActionBar(toolbar)
        supportActionBar?.title = intent.getStringExtra("departmenName")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val pdfList = arrayList(20)
        pdfRecyclerView.adapter = PdfListAdapter (this, pdfList as ArrayList<PdfListData>)
        pdfRecyclerView.layoutManager = LinearLayoutManager(this)
        pdfRecyclerView.setHasFixedSize(true)
    }
    fun arrayList(size: Int): List<PdfListData>{
        val pdfList = ArrayList<PdfListData>()
        for (i in 0 until size){
            pdfList.add(PdfListData("My PDF $i"))
        }
        return pdfList
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}