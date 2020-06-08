package com.mridx.pdflibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        create_account.setOnClickListener {
            startActivity(Intent(this, SignupActvity::class.java))
        }
        user_signIn_btn.setOnClickListener {
            startActivity(Intent(this, DepartmentActivity::class.java))
        }

    }
}
