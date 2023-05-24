package com.example.colorview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.colorview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setListener()


    }

    private fun changeColor(view: View) {
        when (view.id) {
            R.id.box_blue_text -> setColor("Blue" , R.color.my_blue)
            R.id.box_green_text -> setColor("Green", R.color.my_green)
            R.id.box_purple_text -> setColor("Purple",R.color.purple)
            R.id.red_box_text -> setColor("Red" , R.color.my_red)
            R.id.box_clear -> defaultColor()

        }
    }

    private fun setColor(warna : String , color: Int) {
        binding.boxBlueText.setBackgroundResource(color) //
        binding.boxGreenText.setBackgroundResource(color)
        binding.boxPurpleText.setBackgroundResource(color)
        binding.redBoxText.setBackgroundResource(color)

        Toast.makeText(this , "Berhasil mengubah warna"+warna,
        Toast.LENGTH_SHORT).show()


    }

    private fun defaultColor() {
        binding.boxBlueText.setBackgroundResource(R.color.my_blue)
        binding.boxGreenText.setBackgroundResource(R.color.my_green)
        binding.boxPurpleText.setBackgroundResource(R.color.purple)
        binding.redBoxText.setBackgroundResource(R.color.my_red)

        Toast.makeText(this , "Berhasil mengembalikan warna default",
            Toast.LENGTH_SHORT).show()

        val snackB = Snackbar.make(requireViewById(R.id.box_green_text),"test", Snackbar.LENGTH_SHORT)
        snackB.view.setBackgroundResource(R.color.my_green)
        snackB.setTextColor(getColor(R.color.black)) //kenapa get , karena di awal kita menggunakan color itu integer , sedangkan kita butuh teks nya itu string makanya diganti ke get
        snackB.show()
    }

    private fun setListener() {
        val boxBlueText = findViewById<TextView>(R.id.box_blue_text)
        val boxGreenText = findViewById<TextView>(R.id.box_green_text)
        val boxPurpleText = findViewById<TextView>(R.id.box_purple_text)
        val redBoxText = findViewById<TextView>(R.id.red_box_text)
        val clearBox = findViewById<TextView>(R.id.box_clear)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_Layout)

        val clickableView: List<View> =
            listOf(boxBlueText, boxGreenText, boxPurpleText, redBoxText, clearBox,rootConstraintLayout)

        for (item in clickableView) {
            item.setOnClickListener { changeColor(it) }
        }
    }
}
