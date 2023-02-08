package com.example.inventorylock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ConfirmationActivity : AppCompatActivity() {
    lateinit var userEmail: String
    lateinit var confTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmation)
        userEmail = intent.getStringExtra("email").toString()
        confTv = findViewById<TextView>(R.id.confirmTV)
        confTv.text = "На E-mail: $userEmail отправлено письмо с кодом для подтвержджения входа."
    }
    fun onSend(view: View){
        val code = findViewById<TextView>(R.id.confCode).toString()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}