package com.example.listviewpro

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.Manifest
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat

class useractivity : AppCompatActivity() {
    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),101)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useractivity)

        val name=intent.getStringExtra("name")
        val phone=intent.getStringExtra("phoneNumber")
        val img=intent.getIntExtra("imgid",R.drawable.pic1)

        val nametv=findViewById<TextView>(R.id.tvnam)
        val phonetv=findViewById<TextView>(R.id.tvphone)
        val imgid= findViewById<ImageView>(R.id.profile_image)

        nametv.text=name.toString()
        phonetv.text=phone.toString()
        imgid.setImageResource(img)

        checkPermission()
        
        phonetv.setOnClickListener(){
        val phonenum=phone.toString()
            if(phonenum.isNotEmpty()){
                val callintent=Intent(Intent.ACTION_CALL)
                callintent.data= Uri.parse("tel:$phonenum")
                startActivity(callintent)
            }


        }
    }



}