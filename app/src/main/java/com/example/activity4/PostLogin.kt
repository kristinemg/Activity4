package com.example.activity4

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast

class PostLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_login)

        findViewById<Button>(R.id.openCam).setOnClickListener { openCam() }
        findViewById<Button>(R.id.sendEmail).setOnClickListener { sendEmail() }
        findViewById<Button>(R.id.openGoogle).setOnClickListener { openGoogle() }
        findViewById<Button>(R.id.sendSMS).setOnClickListener { sendSMS() }
        findViewById<Button>(R.id.timer).setOnClickListener { timer() }

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

    private fun openGoogle(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent)
        }

    private fun sendSMS(){

        val recNum = "0987809z09x"

        try{
            val num = recNum.toInt()
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: $recNum"))
            startActivity(intent)
        } catch(e: NumberFormatException){
            Toast.makeText(this, "The recepient's number is invalid.", Toast.LENGTH_LONG).show()
        }
    }

    private fun timer(){
        val intent = Intent(AlarmClock.ACTION_SHOW_TIMERS)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Cannot open timer.", Toast.LENGTH_LONG).show()
        }
    }
    }