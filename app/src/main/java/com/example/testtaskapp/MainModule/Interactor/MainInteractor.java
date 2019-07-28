package com.example.testtaskapp.MainModule.Interactor;

import com.example.testtaskapp.MainModule.Presenter.MainPresenterInterface;
import com.example.testtaskapp.Managers.Retrofit.TransportStatus;
import com.example.testtaskapp.Managers.SearchManager.Models.ItemsModel;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;
import com.example.testtaskapp.Managers.SearchManager.SearchCallback;
import com.example.testtaskapp.Managers.SearchManager.SearchManager;

import java.util.Collections;
import java.util.Comparator;

public class MainInteractor {
    private MainPresenterInterface presenterInterface;
    private SearchManager manager  = new SearchManager();

    public MainInteractor(MainPresenterInterface presenterInterface){
        this.presenterInterface = presenterInterface;
    }

    public void sendSearchRequest(String term){
        manager.searchRequest(term, new SearchCallback() {
            @Override
            public void onSuccess(SearchResponce searchResponce) {
                //Сортировка по алфавиту
                Collections.sort(searchResponce.results, new Comparator<ItemsModel>() {
                    public int compare(ItemsModel o1, ItemsModel o2) {
                        return o1.collectionName.compareTo(o2.collectionName);
                    }
                });

                presenterInterface.onSuccessSearchRequest(searchResponce);
            }

            @Override
            public void onError(TransportStatus status) {
                presenterInterface.onError(status);
            }
        });
    }

    public void getAlbumInfo(Integer idCollection){
        manager.getAlbumInfo(idCollection, new SearchCallback() {
            @Override
            public void onSuccess(SearchResponce searchResponce) {
                presenterInterface.onSuccessAlbumInfoRequest(searchResponce);
            }

            @Override
            public void onError(TransportStatus status) {
                presenterInterface.onError(status);
            }
        });
    }
}
