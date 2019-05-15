package com.example.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.text.InputType
import android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
import android.text.InputType.TYPE_CLASS_TEXT
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var total:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL or InputType.TYPE_NUMBER_FLAG_SIGNED
        edit1.setInputType(inputType)
        edit2.setInputType(inputType)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1){
            count(button1.text.toString())

        }else if(v.id == R.id.button2) {
            count(button2.text.toString())

        }else if(v.id == R.id.button3) {
            count(button3.text.toString())

        }else if(v.id == R.id.button4){
            count(button4.text.toString())
        }
    }

    fun count(sylbom:String) {
        val xxx = edit1.text.toString().toDouble()
        val yyy = edit2.text.toString().toDouble()
        when(sylbom){
            "+" -> total = xxx + yyy
            "-" -> total = xxx-yyy
            "*" -> total = xxx*yyy
            "/" -> total = xxx/yyy
        }
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("Total",total)
        startActivity(intent)

    }
}
