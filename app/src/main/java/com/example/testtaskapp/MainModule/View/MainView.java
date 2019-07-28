package com.example.testtaskapp.MainModule.View;

import android.view.View;

import com.example.testtaskapp.Managers.Retrofit.TransportStatus;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

public interface MainView {
    void showAlbumInfoFragment(SearchResponce searchResponce);
    void showErrorMessage(String errorMessage);
    void hideEmptyLabel();
    void showEmptyLabel();
    void showProgressBar();
    void hideProgressBar();
}
