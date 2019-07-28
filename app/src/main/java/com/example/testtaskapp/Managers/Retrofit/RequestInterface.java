package com.example.testtaskapp.Managers.Retrofit;

import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {

    @GET("search?country=RU&media=music&entity=album&attribute=albumTerm")
    Call<SearchResponce> searchRequest(@Query("term") String term);

    @GET("https://itunes.apple.com/lookup?media=music&entity=song&country=RU&limit=1000")
    Call<SearchResponce> getAlbumInfo(@Query("id") Integer collectionId);
}
