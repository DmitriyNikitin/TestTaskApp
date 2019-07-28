package com.example.testtaskapp.AlbumInfoModule.Presenter;

import com.example.testtaskapp.AlbumInfoModule.View.AlbumInfoRvAdapter;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

public class AlbumInfoPresenter {
    private AlbumInfoRvAdapter rvAdapter;
    SearchResponce response;

    public void setModel(SearchResponce response){
        this.response = response;
    }

    public AlbumInfoRvAdapter getAdapter(){
        if(rvAdapter == null)
            rvAdapter = new AlbumInfoRvAdapter();
            rvAdapter.setModel(response.results);
        return rvAdapter;
    }
}
