package com.mridx.pdflibrary.UI

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        topAppBar.setOnClickListener {
                startActivity(Intent(this, DepartmentActivity::class.java))
               finish()
        }
        topAppBar.title = intent.getStringExtra("pdfName")

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
}