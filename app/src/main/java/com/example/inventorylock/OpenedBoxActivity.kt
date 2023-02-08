package com.example.inventorylock

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class OpenedBoxActivity : AppCompatActivity() {
    lateinit var color: String
    var id = 0
    lateinit var tvBox: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.opened_box)
        id = intent.getIntExtra("id", 0)
        color = intent.getStringExtra("color").toString()
        tvBox = findViewById<TextView>(R.id.tvBox)
        tvBox.text = "$color ящик №$id открыт."
    }

    fun onCloseBox(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}