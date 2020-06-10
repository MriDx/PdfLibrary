package com.mridx.pdflibrary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mridx.pdflibrary.UI.Recycler.DepartmentActivity
import kotlinx.android.synthetic.main.login_ui.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_ui)
         create_account.setOnClickListener {
             startActivity(Intent(this, SignupActvity::class.java))
         }
         user_signIn_btn.setOnClickListener {
             startActivity(Intent(this, DepartmentActivity::class.java))
         }

    }
}
