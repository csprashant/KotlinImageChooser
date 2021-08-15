package com.example.imagechosserkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var btn:Button
    lateinit var imageView: ImageView
    lateinit var uri:Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            val intent: Intent = Intent()
            intent.setAction(Intent.ACTION_PICK)
            intent.setType("image/*")
            startActivityForResult(Intent.createChooser(intent, "choseimage"), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1 && resultCode== RESULT_OK && data!=null && data.data!=null)
             uri= data?.data!!
            try{
                imageView.setImageURI(uri)
            }catch (e:Exception)
            {
                Log.e("Image",e.message.toString())
            }

    }
}