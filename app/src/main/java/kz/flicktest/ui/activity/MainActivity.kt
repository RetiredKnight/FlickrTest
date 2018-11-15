package kz.flicktest.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import kz.flicktest.base.BaseActivity
import kz.flicktest.R
import kz.flicktest.databinding.ActivityMainBinding
import kz.flicktest.network.model.FlickrPhotos
import kz.flicktest.ui.adapter.PhotoAdapter
import kz.flicktest.ui.presenter.MainPresenter
import kz.flicktest.ui.views.MainView

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val photoAdapter = PhotoAdapter(this)
    private var suggestionsAdapter: ArrayAdapter<String>? = null
    private var suggestions = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        suggestionsAdapter = ArrayAdapter(getContext(), android.R.layout.select_dialog_item, suggestions)
        binding.adapter = photoAdapter
        binding.layoutManager = GridLayoutManager(this, 3)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        binding.searchInput.setAdapter(suggestionsAdapter)
        binding.searchInput.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.loadImages(v.text.toString())
                suggestionsAdapter!!.add(v.text.toString())
                true
            } else {
                false
            }
        }
        binding.executePendingBindings()
        presenter.onViewCreated()

    }

    override fun instantiatePresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun updatePhotos(photos: FlickrPhotos) {
        photoAdapter.updatePhotos(photos.photos.photo)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

}