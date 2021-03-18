package com.bangkit.ilt_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide



class DetailActivity : AppCompatActivity() {

    companion object {
        const val ARTIST_OBJECT = "artist_object"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val txtName : TextView = findViewById(R.id.tvArtistName)
        val imgArtist: ImageView = findViewById(R.id.imgArtistPhoto)

        val artist = intent.getParcelableExtra<Artist>(ARTIST_OBJECT) as Artist


        txtName.text = artist.name
        Glide.with(this)
            .load(artist.photo)
            .into(imgArtist)


    }


}