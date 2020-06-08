package com.mridx.pdflibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.department_recycler.*

class DepartmentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.department_recycler)
       department_recycler_view.layoutManager = GridLayoutManager(this,2)
        department_recycler_view.setHasFixedSize(true)
    }
}