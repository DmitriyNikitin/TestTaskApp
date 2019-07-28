package com.example.testtaskapp.Managers.SearchManager;


import com.example.testtaskapp.Managers.Retrofit.RetrofitManager;
import com.example.testtaskapp.Managers.Retrofit.TransportStatus;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchManager {

    public void searchRequest(String term, final SearchCallback searchCallback){
        RetrofitManager.getInstance().getRequestInterface().searchRequest(term).enqueue(new Callback<SearchResponce>() {
            @Override
            public void onResponse(Call<SearchResponce> call, Response<SearchResponce> response) {
                TransportStatus status = TransportStatus.getStatus(response.code());

                if(status == TransportStatus.StatusSuccess)
                    searchCallback.onError(status);

                searchCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SearchResponce> call, Throwable t) {
               searchCallback.onError(TransportStatus.getStatus(t));
            }
        });
    }

    public void getAlbumInfo(Integer collectionId, final SearchCallback searchCallback){

        RetrofitManager.getInstance().getRequestInterface().getAlbumInfo(collectionId).enqueue(new Callback<SearchResponce>() {
            @Override
            public void onResponse(Call<SearchResponce> call, Response<SearchResponce> response) {
                TransportStatus status = TransportStatus.getStatus(response.code());

                if(status == TransportStatus.StatusSuccess)
                    searchCallback.onError(status);

                searchCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SearchResponce> call, Throwable t) {
                searchCallback.onError(TransportStatus.getStatus(t));
            }
        });
    }

}
