package com.busealtac.succulentshop

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val yesButton: Button = findViewById(R.id.yesButton)
        val noButton: Button = findViewById(R.id.noButton)

        yesButton.setOnClickListener {
            setResult(RESULT_YES)  //büyük data olarak bundle gönderebilirsin
            finish()
        }

        noButton.setOnClickListener {
            setResult(RESULT_NO)
            finish()

        }
    }

    companion object {
        const val RESULT_YES = 1
        const val RESULT_NO = 0

    }

}