package com.mridx.pdflibrary.UI.Recycler

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.department_recycler.*

class DepartmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.department_recycler)
        val departmentList = arrayList(50)
        department_recycler_view.layoutManager = GridLayoutManager(this, 2)
        department_recycler_view.adapter = DepartmentAdapter( this, departmentList as ArrayList<DepartmentData>)
        department_recycler_view.setHasFixedSize(true)
    }

    private fun arrayList(size: Int): List<DepartmentData> {
        val list = ArrayList<DepartmentData>()
        for (i in 0 until size) {
            list.add(DepartmentData("Department $i"))
        }
        return list
    }

}