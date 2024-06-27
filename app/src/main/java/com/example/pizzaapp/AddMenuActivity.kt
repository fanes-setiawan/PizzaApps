package com.example.pizzaapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzaapp.R
import com.example.pizzaapp.database.DatabaseHelper
import java.io.ByteArrayOutputStream

class AddMenuActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var imageViewPhoto: ImageView
    private lateinit var buttonSave: Button
    private lateinit var db: DatabaseHelper
    private var selectedImageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)

        editTextName = findViewById(R.id.editTextName)
        editTextDescription = findViewById(R.id.editTextDescription)
        editTextPrice = findViewById(R.id.editTextPrice)
        imageViewPhoto = findViewById(R.id.imageViewPhoto)
        buttonSave = findViewById(R.id.buttonSave)
        db = DatabaseHelper(this)

        imageViewPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)
        }

        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            val description = editTextDescription.text.toString()
            val price = editTextPrice.text.toString().toDouble()
            val image = getImageAsByteArray(selectedImageBitmap)
            if (db.insertMenu(name, description, price, image)) {
                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            val inputStream = contentResolver.openInputStream(imageUri!!)
            selectedImageBitmap = BitmapFactory.decodeStream(inputStream)
            imageViewPhoto.setImageBitmap(selectedImageBitmap)
        }
    }

    private fun getImageAsByteArray(bitmap: Bitmap?): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }
}