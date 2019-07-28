package com.example.testtaskapp.MainModule.Presenter;

import android.content.Context;
import android.os.CountDownTimer;

import com.example.testtaskapp.MainModule.Interactor.MainInteractor;
import com.example.testtaskapp.MainModule.View.MainRvAdapter;
import com.example.testtaskapp.MainModule.View.MainView;
import com.example.testtaskapp.Managers.Retrofit.TransportStatus;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;
import com.example.testtaskapp.Managers.SearchManager.SearchCallback;
import com.example.testtaskapp.R;

public class MainPresenter implements MainPresenterInterface {

    private MainRvAdapter rvAdapter;
    private MainView mainView;
    private Context context;
    private MainInteractor interactor;

    public MainPresenter(MainView mainView, Context context){
        this.context = context;
        this.mainView = mainView;
        interactor = new MainInteractor(this);
    }

    public MainRvAdapter getAdapter(){
        if(rvAdapter == null)
            rvAdapter = new MainRvAdapter(this);
        return rvAdapter;
    }


    public void sendSearchRequest(String term){
        mainView.showProgressBar();
        interactor.sendSearchRequest(term);
    }

    @Override
    public void onSuccessSearchRequest(SearchResponce responce) {
        mainView.hideProgressBar();
        rvAdapter.setItemModel(responce.results);

        if(responce.results.size() > 0){
            mainView.hideEmptyLabel();
        }else {
            mainView.showEmptyLabel();
        }

    }

    @Override
    public void onSuccessAlbumInfoRequest(SearchResponce responce) {
        mainView.hideProgressBar();
        mainView.showAlbumInfoFragment(responce);
    }

    @Override
    public void onError(TransportStatus status) {
        mainView.hideProgressBar();
        switch (status) {
            case StatusError:
                mainView.showErrorMessage(context.getResources().getString(R.string.unknown_error));
                break;
            case StatusNotInternet:
                mainView.showErrorMessage(context.getResources().getString(R.string.network_error));
                break;

            default:
                break;
        }
    }

    @Override
    public void onClickItem(Integer idCollection) {
        mainView.showProgressBar();
        interactor.getAlbumInfo(idCollection);
    }


}
