package com.example.cardholder

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class AddActivity : AppCompatActivity() {
    private val PICK_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val toast = Toast.makeText(applicationContext, intent.getStringArrayExtra("ScanResult")!![0], Toast.LENGTH_SHORT)
        toast.show()
    }
}