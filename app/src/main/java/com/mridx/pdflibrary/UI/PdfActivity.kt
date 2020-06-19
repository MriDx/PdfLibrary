package com.mridx.pdflibrary.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.mridx.pdflibrary.R
import com.mridx.pdflibrary.UI.Recycler.DepartmentActivity
import kotlinx.android.synthetic.main.pdfview.*

class PdfActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pdfview)
        pdfViewer()
        val intent = intent
        setSupportActionBar(toolbar)
        supportActionBar?.title = intent.getStringExtra("pdfName")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun pdfViewer(){
        pdfView.fromAsset("sample.pdf")
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(0)
            .enableAnnotationRendering(false)
            .password(null)
            .scrollHandle(null)
            .enableAntialiasing(true)
            .spacing(0)
            .load()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}