package com.bangkit.ilt_5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView


import java.util.ArrayList


class ArtistAdapter(private val listArtist: ArrayList<Artist>, private val onClick: (Artist) -> Unit) : RecyclerView.Adapter<ArtistAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : CircleImageView = itemView.findViewById(R.id.imageArtist)
        val textName : TextView = itemView.findViewById(R.id.nameArtist)

        fun bind(artist : Artist){
            with(itemView){
                Glide.with(itemView.context)
                    .load(artist.photo)
                    .into(image)
                    textName.text = artist.name
            }

            itemView.setOnClickListener {
                onClick(artist)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_artist, parent, false)
        return ListViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listArtist[position])
    }

    override fun getItemCount(): Int {
        return listArtist.size
    }


}