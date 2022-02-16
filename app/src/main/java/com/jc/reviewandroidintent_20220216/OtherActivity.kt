package com.jc.reviewandroidintent_20220216

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val SEND_NAME = "name"
        val SEND_PHONE = "phone"

        val name = intent.getStringExtra(SEND_NAME).toString()
        val phone = intent.getStringExtra(SEND_PHONE).toString()

        getNameTextView.text = name
        getPhoneTextView.text = phone


        sendInfoButton.setOnClickListener {

            val changeName = changeUserNameEditText.text.toString()
            val changePhone = changeUserPhoneEditText.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra(SEND_NAME, changeName)
            resultIntent.putExtra(SEND_PHONE, changePhone)

            setResult(RESULT_OK, resultIntent)

            finish()

        }


    }
}