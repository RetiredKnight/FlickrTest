package kz.flicktest.network.api

import io.reactivex.Observable
import kz.flicktest.network.model.FlickrPhotos
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {

    @GET("/services/rest/")
    fun getFlickrPhotos(@Query("method") method: String,
                        @Query("api_key") apiKey: String,
                        @Query("text") text: String,
                        @Query("format") format : String,
                        @Query("nojsoncallback") value: Int
                        ): Observable<FlickrPhotos>

}