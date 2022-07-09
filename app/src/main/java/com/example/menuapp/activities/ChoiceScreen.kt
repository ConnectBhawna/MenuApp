package com.example.menuapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menuapp.R
import kotlinx.android.synthetic.main.activity_choice_screen.*

class ChoiceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_screen)


        btn_np.setOnClickListener{
            startActivity(Intent(this@ChoiceScreen, MainActivity::class.java))
        }

        btn_yes.setOnClickListener{
            startActivity(Intent(this@ChoiceScreen, CheckAdmin::class.java))
        }



    }
}