package com.example.testtaskapp.MainModule.Presenter;

import com.example.testtaskapp.Managers.Retrofit.TransportStatus;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

public interface MainPresenterInterface {
    void onClickItem(Integer idCollection);
    void onSuccessSearchRequest(SearchResponce responce);
    void onSuccessAlbumInfoRequest(SearchResponce responce);
    void onError(TransportStatus status);
}
