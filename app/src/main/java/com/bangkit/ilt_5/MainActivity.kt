package com.bangkit.ilt_5


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Artist>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvArtist : RecyclerView = findViewById(R.id.rvArtist)
        val artistAdapter = ArtistAdapter(list) {

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.ARTIST_OBJECT, it)
            startActivity(intent)

        }
        rvArtist.adapter = artistAdapter
        rvArtist.layoutManager = LinearLayoutManager(this)

        list.addAll(getListArtist())

    }

    private fun getListArtist(): ArrayList<Artist>{
        val name = resources.getStringArray(R.array.data_name)
        val photo = resources.getStringArray(R.array.data_photo)

        val listArtist = ArrayList<Artist>()
        for (i in name.indices){
            val artist = Artist(
                photo[i],
                name[i]
            )
            listArtist.add(artist)
        }

        return listArtist

    }


}