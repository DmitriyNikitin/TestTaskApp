package com.example.testtaskapp.AlbumInfoModule.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testtaskapp.AlbumInfoModule.Presenter.AlbumInfoPresenter;
import com.example.testtaskapp.R;
import com.example.testtaskapp.Managers.SearchManager.Models.SearchResponce;

public class AlbumInfoFragment extends Fragment {

    private static final String SEARCH_RESPONSE = "SEARCH" ;
    private View view;
    private RecyclerView albumInfoRV;
    private AlbumInfoPresenter presenter;

    public static AlbumInfoFragment newInstance(SearchResponce searchResponse) {
        Bundle args = new Bundle();
        args.putSerializable(SEARCH_RESPONSE, searchResponse);
        AlbumInfoFragment fragment = new AlbumInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new AlbumInfoPresenter();
        presenter.setModel((SearchResponce)getArguments().getSerializable(SEARCH_RESPONSE));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album_info, container, false);

        albumInfoRV = view.findViewById(R.id.albumInfoRV);
        albumInfoRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        albumInfoRV.setAdapter(presenter.getAdapter());

        return view;
    }
}
