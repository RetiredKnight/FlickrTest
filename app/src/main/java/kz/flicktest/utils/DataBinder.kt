@file:Suppress("unused")

package kz.flicktest.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kz.flicktest.ui.adapter.PhotoAdapter

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: PhotoAdapter) {
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}

@BindingAdapter("picasso")
fun setImagePicasso(view: ImageView, imageUrl: String) {
    Picasso.get()
            .load(imageUrl)
            .resize(100, 100)
            .centerCrop()
            .into(view)
}

@BindingAdapter("suggestionsAdapter")
fun setSuggestionsAdapter(view: AutoCompleteTextView, adapter: ArrayAdapter<String>) {
    view.setAdapter(adapter)
}

@BindingAdapter("picassofull")
fun setFullImage(view: ImageView, imageUrl: String) {
    Picasso.get()
            .load(imageUrl)
            .into(view)
}