package com.example.simpleapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        change.setOnClickListener {
            if(editText.text.trim().isNotEmpty()) {
                textView.text = "Hello, ${editText.text}!"
            } else {
                textView.text = "TYPE SOMETHING, HEATHEN!"
            }
        }
    }

    fun triggerAlert(view: View) {
        textView.text = ""
        editText.text.clear()
        val build = AlertDialog.Builder(this)
        build.setTitle("AHA!")
        build.setMessage("YOU TRIGGERED ME!")
        build.setNeutralButton("Go away (please)") { _,_ ->
            Toast.makeText(this, "You closed me!", Toast.LENGTH_LONG).show()
        }

        val dialog = build.create()
        dialog.show()
    }
}
