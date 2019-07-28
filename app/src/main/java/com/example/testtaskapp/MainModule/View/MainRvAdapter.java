package com.example.testtaskapp.MainModule.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testtaskapp.MainModule.Presenter.MainPresenterInterface;
import com.example.testtaskapp.Managers.SearchManager.Models.ItemsModel;
import com.example.testtaskapp.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.AlbumViewHolder> {

    private List<ItemsModel> itemsModels;
    private MainPresenterInterface presenterInterface;

    public MainRvAdapter(MainPresenterInterface presenterInterface){
        this.presenterInterface = presenterInterface;
    }

    public void setItemModel(List<ItemsModel> itemsModels){
        this.itemsModels = itemsModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainRvAdapter.AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_album, viewGroup, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRvAdapter.AlbumViewHolder viewHolder, int i) {
        viewHolder.initData(itemsModels.get(i));
    }

    @Override
    public int getItemCount() {
        if(itemsModels != null)
            return itemsModels.size();
        return 0;
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageAlbum;
        private TextView nameAlbum;
        private TextView countTrack;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAlbum = itemView.findViewById(R.id.imageAlbum);
            nameAlbum = itemView.findViewById(R.id.nameAlbum);
            countTrack = itemView.findViewById(R.id.countTrack);
        }

        public void initData(final ItemsModel itemsModel){
            Picasso.get()
                    .load(itemsModel.artworkUrl100)
                    .placeholder(android.R.drawable.ic_menu_camera)
                    .error(android.R.drawable.ic_menu_camera)
                    .into(imageAlbum);
            
            nameAlbum.setText(itemsModel.collectionName);
            countTrack.setText(String.format(countTrack.getContext().getString(R.string.count_tracks), itemsModel.trackCount));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenterInterface.onClickItem(itemsModel.collectionId);
                }
            });

        }

    }


}
