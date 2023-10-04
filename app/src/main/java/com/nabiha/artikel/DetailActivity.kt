package com.nabiha.artikel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nabiha.artikel.databinding.ActivityDetailBinding
import com.nabiha.artikel.model.ArtikelModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detail: ArtikelModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        detail = intent.getSerializableExtra("intent_task") as ArtikelModel

        binding.title.text = detail.title
        binding.deskripsiArtikel.text = detail.desc
        binding.imageArtikel.setImageResource(detail.image)
        binding.view.text = detail.view.toString()
        binding.time.text = detail.time

        val intent = Intent(this@DetailActivity, HomeActivity::class.java)
        binding.backBtn.setOnClickListener{
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}