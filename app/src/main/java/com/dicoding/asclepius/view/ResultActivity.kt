package com.dicoding.asclepius.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.asclepius.R
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = intent.getStringExtra("imageUri")
        imageUri?.let {
            binding.resultImage.setImageURI(Uri.parse(it))
        } ?: run {
            binding.resultText.text = "No image available"
        }

        val prediction = intent.getStringExtra("prediction")
        binding.resultText.text = prediction ?: "No predictions available"
    }
}