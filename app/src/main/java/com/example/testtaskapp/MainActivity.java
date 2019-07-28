package com.example.testtaskapp;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testtaskapp.AlbumInfoModule.View.AlbumInfoFragment;
import com.example.testtaskapp.MainModule.Presenter.MainPresenter;
import com.example.testtaskapp.MainModule.View.MainView;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText searchET;
    private RecyclerView albumsRV;
    private MainPresenter presenter;
    private boolean isStart = false;
    private boolean isShowInfoAlbum = false;
    private SearchResponce searchResponce;
    private TextView emptyLabel;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this, getApplicationContext());

        searchET = findViewById(R.id.searchET);
        emptyLabel = findViewById(R.id.emptyLabel);
        progressBar = findViewById(R.id.progressBar);
        albumsRV = findViewById(R.id.albumsRV);
        albumsRV.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
        albumsRV.setAdapter(presenter.getAdapter());

        searchET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    presenter.sendSearchRequest(searchET.getText().toString());
                    albumsRV.requestFocus();
                    hideKeyboard();

                    return true;
                }
                return false;
            }
        });


    }

    @Override
    public void showEmptyLabel(){
        emptyLabel.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyLabel(){
        emptyLabel.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }

    public void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) getApplication().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchET.getWindowToken(), 0);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this,errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
         isStart = true;
         if(isShowInfoAlbum)
             showAlbumInfoFragment(searchResponce);
    }

    @Override
    protected void onStop() {
        super.onStop();
        isStart = false;
    }

    @Override
    public void showAlbumInfoFragment(SearchResponce searchResponce) {
        //Если приложение свернут до того как вернется ответ с сервера, приложение не выполнит код ниже, но запомнит
        // ответ и при раскрытии приложение загрузит экран.
        if(!isStart){
            this.searchResponce = searchResponce;
            isShowInfoAlbum = true;
            return;
        }
        isShowInfoAlbum = false;

        AlbumInfoFragment albumInfoFragment = AlbumInfoFragment.newInstance(searchResponce);
        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,albumInfoFragment );
        fragmentTransaction.addToBackStack(albumInfoFragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
