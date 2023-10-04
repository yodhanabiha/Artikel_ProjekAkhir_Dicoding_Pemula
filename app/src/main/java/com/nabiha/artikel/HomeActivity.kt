package com.nabiha.artikel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.nabiha.artikel.adapter.ArtikelAdapter
import com.nabiha.artikel.databinding.ActivityHomeBinding
import com.nabiha.artikel.model.ArtikelModel
import kotlin.random.Random


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var taskAdapter: ArtikelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this@HomeActivity, DetailActivity::class.java)
        val about = Intent(this@HomeActivity, AboutActivity::class.java)

        val data = arrayListOf(
            ArtikelModel(1, R.drawable.wayang, getString(R.string.title_item_1), getString(R.string.deskripsi_item_1), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(2, R.drawable.batik, getString(R.string.title_item_2), getString(R.string.deskripsi_item_2), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(3, R.drawable.kayu, getString(R.string.title_item_3), getString(R.string.deskripsi_item_3), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(4, R.drawable.gamelan, getString(R.string.title_item_4), getString(R.string.deskripsi_item_4), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(5, R.drawable.topeng, getString(R.string.title_item_5), getString(R.string.deskripsi_item_5), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(6, R.drawable.keris, getString(R.string.title_item_6), getString(R.string.deskripsi_item_6), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(7, R.drawable.makananbetawo, getString(R.string.title_item_7), getString(R.string.deskripsi_item_7), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(8, R.drawable.golek, getString(R.string.title_item_8), getString(R.string.deskripsi_item_8), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(9, R.drawable.tenun, getString(R.string.title_item_9), getString(R.string.deskripsi_item_9), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
            ArtikelModel(10, R.drawable.reog, getString(R.string.title_item_10), getString(R.string.deskripsi_item_10), Random.nextInt(1, 999), "${Random.nextInt(1,6)} Hari Lalu"),
        )

        taskAdapter = ArtikelAdapter(
            data,
            object : ArtikelAdapter.AdapterListener {
                override fun onDetail(taskModel: ArtikelModel) {
                    intent.putExtra("intent_task", taskModel)
                    startActivity(intent)
                }
            }
        )

        binding.menuBtn.setOnClickListener {
            PopupMenu( this@HomeActivity , it).apply {
                setOnMenuItemClickListener { item ->
                    when(item?.itemId){
                        R.id.abut->{
                            startActivity(about)
                            true
                        }
                        else -> false
                    }
                }
                inflate(R.menu.menu_about)
                show()
            }
        }

        binding.artikelKonten.layoutManager = LinearLayoutManager(this)
        binding.artikelKonten.adapter = taskAdapter
    }
}