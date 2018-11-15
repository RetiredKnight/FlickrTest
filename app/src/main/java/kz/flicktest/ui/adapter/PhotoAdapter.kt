package kz.flicktest.ui.adapter

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.flicktest.R
import kz.flicktest.databinding.PhotoItemBinding
import kz.flicktest.network.model.Photo
import kz.flicktest.ui.activity.FullScreenActivity
import kz.flicktest.ui.viewholder.PhotoViewHolder

class PhotoAdapter(private val context: Context) : RecyclerView.Adapter<PhotoViewHolder>() {

    private var photos: List<Photo> = listOf()
    private lateinit var binding: PhotoItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.photo_item, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
        holder.showFullScreen(photos[position], context)
    }

    fun updatePhotos(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }
}