package com.mridx.pdflibrary.UI

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.pdfview.*

class PdfViewActivity: AppCompatActivity() {
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