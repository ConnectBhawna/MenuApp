package com.example.menuapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menuapp.R
import kotlinx.android.synthetic.main.activity_check_admin.*
import kotlinx.android.synthetic.main.activity_choice_screen.*

class CheckAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_admin)

        button_submit.setOnClickListener{
            startActivity(Intent(this@CheckAdmin, MainActivity::class.java))
        }
    }
}