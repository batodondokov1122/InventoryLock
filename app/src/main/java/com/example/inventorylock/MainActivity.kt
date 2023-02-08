package com.example.inventorylock

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inventorylock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BoxAdapter.Listener {
    lateinit var binding: ActivityMainBinding
    private val adapter = BoxAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcv.layoutManager = LinearLayoutManager(this@MainActivity)
            rcv.adapter = adapter
        }
    }

    private fun openDialog(box: Box){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Управление")
        builder.setMessage("Вы хотите открыть ${box.color} ящик №${box.id}?")
        builder.setPositiveButton("ДА"){ dialogInterface, i ->
            val intent = Intent(this, OpenedBoxActivity::class.java)
            intent.putExtra("id", box.id)
            intent.putExtra("color", box.color)
            startActivity(intent)
        }
        builder.setNegativeButton("НЕТ"){
                dialog, i ->
        }

        builder.show()
    }

    override fun onClick(box: Box) {
        if (box.status){
            openDialog(box)
        }
    }
}