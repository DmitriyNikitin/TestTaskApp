package com.example.testtaskapp.Managers.SearchManager;

import com.example.testtaskapp.Managers.Retrofit.TransportStatus;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

public interface SearchCallback {
    void onSuccess(SearchResponce searchResponce);
    void onError(TransportStatus status);

}
