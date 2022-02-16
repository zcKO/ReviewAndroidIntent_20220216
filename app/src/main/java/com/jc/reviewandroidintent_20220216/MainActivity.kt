package com.jc.reviewandroidintent_20220216

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_USERINFO_CODE: Int = 1000
    val SEND_NAME: String = "name"
    val SEND_PHONE = "phone"
    val SMS_BODY = "sms_body"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveButton.setOnClickListener {

            val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)

        }

        sendDataButton.setOnClickListener {

            val sendData = userNameEditText.text.toString()
            val phoneData = phoneEditText.text.toString()

            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra(SEND_NAME, sendData)
            intent.putExtra(SEND_PHONE, phoneData)
            startActivity(intent)

        }

        inputDataButton.setOnClickListener {

            val sendData = userNameEditText.text.toString()
            val phoneData = phoneEditText.text.toString()

            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra(SEND_NAME, sendData)
            intent.putExtra(SEND_PHONE, phoneData)
            startActivityForResult(intent, REQ_USERINFO_CODE)

        }

        dialButton.setOnClickListener {

            val phoneNumber = phoneEditText.text.toString()
            val uri = Uri.parse("tel:${phoneNumber}")

            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)

        }

        callButton.setOnClickListener {

            val phoneNumber = phoneEditText.text.toString()
            val uri = Uri.parse("tel:${phoneNumber}")

            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)

        }

        sendSmsButton.setOnClickListener {

            val phoneNumber = phoneEditText.text.toString()
            val uri = Uri.parse("smsto:${phoneNumber}")

            val intent = Intent(Intent.ACTION_SENDTO, uri)
            val userName = userNameEditText.text.toString()

            // 내용 담아서 보내기
            intent.putExtra(SMS_BODY, userName)
            startActivity(intent)

        }

        naverButton.setOnClickListener {

            val uri = Uri.parse("https://www.naver.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }

//        marketButton

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // 코드가 맞는지 확인
        if (requestCode == REQ_USERINFO_CODE) {

            if (resultCode == RESULT_OK) {

                val newName = data?.getStringExtra(SEND_NAME)
                val newPhone = data?.getStringExtra(SEND_PHONE)

                userNameEditText.setText(newName)
                phoneEditText.setText(newPhone)

            }

        }

    }
}