package com.mridx.pdflibrary.UI

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.pdfview.*

class PdfActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pdfview)
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
            .load();
    }
}