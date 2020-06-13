package com.mridx.pdflibrary.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mridx.pdflibrary.R
import kotlinx.android.synthetic.main.signup_ui.*

class SignupActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_ui)
        exist_account_SignIn.setOnClickListener {
            finish()
        }
    }
}
