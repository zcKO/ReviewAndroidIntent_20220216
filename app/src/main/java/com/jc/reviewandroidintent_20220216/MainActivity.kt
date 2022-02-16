package com.jc.reviewandroidintent_20220216

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveButton.setOnClickListener {

            val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)

        }

        sendDataButton.setOnClickListener {

            val SEND_NAME = "name"
            val SEND_PHONE = "phone"

            val sendData = userNameEditText.text.toString()
            val phoneData = phoneEditText.text.toString()

            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra(SEND_NAME, sendData)
            intent.putExtra(SEND_PHONE, phoneData)
            startActivity(intent)

        }

    }
}