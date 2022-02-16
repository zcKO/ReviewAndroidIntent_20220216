package com.jc.reviewandroidintent_20220216

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val SEND_NAME = "name"
        val SEND_PHONE = "phone"

        val name = intent.getStringExtra(SEND_NAME)
        val phone = intent.getStringExtra(SEND_PHONE)

        getNameTextView.text = name
        getPhoneTextView.text = phone

    }
}