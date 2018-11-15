package kz.flicktest.ui.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import kz.flicktest.databinding.PhotoItemBinding
import kz.flicktest.network.model.Photo
import kz.flicktest.ui.activity.FullScreenActivity

class PhotoViewHolder(private val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) {
        var url: String = "https://farm"+photo.farm+".staticflickr.com/" +
                photo.server+"/"+photo.id+"_"+photo.secret+".jpg"
        binding.imageUrl = url
        binding.executePendingBindings()
    }

    fun showFullScreen(photo: Photo, context: Context) {
        var url: String = "https://farm"+photo.farm+".staticflickr.com/" +
                photo.server+"/"+photo.id+"_"+photo.secret+".jpg"
        binding.photoView.setOnClickListener {
            var intent = Intent(context, FullScreenActivity::class.java)
            intent.putExtra("url", url)
            context.startActivity(intent)
        }
    }

}