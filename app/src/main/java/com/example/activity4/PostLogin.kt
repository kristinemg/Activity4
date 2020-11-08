package com.example.activity4

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class PostLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_login)

        findViewById<Button>(R.id.openCam).setOnClickListener { openCam() }
        findViewById<Button>(R.id.sendEmail).setOnClickListener { sendEmail() }
        findViewById<Button>(R.id.openDevWeb).setOnClickListener { openDevWeb() }

    }

    private fun openCam(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 1)
    }

    private fun sendEmail(){

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto: cc17@gmail.com")
        intent.putExtra(Intent.EXTRA_EMAIL, "test")
        intent.putExtra(Intent.EXTRA_SUBJECT, "CC17 Email")

        startActivity(intent)
    }

    private fun openDevWeb(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent)
        }
    }