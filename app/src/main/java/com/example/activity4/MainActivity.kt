package com.example.activity4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.loginBtn).setOnClickListener {

            val usernameTxt = findViewById<EditText>(R.id.editName)
            val username: String = usernameTxt.text.toString()

            val passwordTxt = findViewById<EditText>(R.id.editPW)
            val password: String = passwordTxt.text.toString()

            if ((username == "kris") && (password == "0000")) {
                val button = findViewById<Button>(R.id.loginBtn)
                button.setOnClickListener {
                    val intent = Intent(this, PostLogin::class.java)
                    startActivity(intent)
            }
        }
        }
    }
}