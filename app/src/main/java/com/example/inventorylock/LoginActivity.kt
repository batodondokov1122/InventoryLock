package com.example.inventorylock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }

    fun onLogin(view: View) {
        val userName = findViewById<TextView>(R.id.userName).text.toString()
        val userEmail = findViewById<TextView>(R.id.userEmail).text.toString()
        Log.d("mytag", userEmail)
        val intent = Intent(this, ConfirmationActivity::class.java)
        intent.putExtra("email", userEmail)
        startActivity(intent)
    }
}