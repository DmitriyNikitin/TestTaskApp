package com.example.testtaskapp.AlbumInfoModule.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testtaskapp.R;
import com.example.testtaskapp.Managers.SearchManager.Models.ItemsModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AlbumInfoRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int ALBUM_TYPE = 0;
    private final int TRACK_TYPE = 1;
    private List<ItemsModel> itemsModels;


    public void setModel(List<ItemsModel> itemsModels){
        this.itemsModels = itemsModels;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (itemsModels.get(position).wrapperType.equals("collection")) {
            return ALBUM_TYPE;
        }

        if (itemsModels.get(position).wrapperType.equals("track")) {
            return TRACK_TYPE;
        }

        return TRACK_TYPE;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case ALBUM_TYPE:{
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_info_album, viewGroup, false);
                AlbumHolder albumHolder = new AlbumHolder(view);
                return albumHolder;
            }
            case TRACK_TYPE:{
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_track, viewGroup, false);
                TrackHolder trackHolder = new TrackHolder(view);
                return trackHolder;
            }
            default:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_track, viewGroup, false);
                TrackHolder trackHolder = new TrackHolder(view);
                return trackHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder baseViewHolder, int i) {

        if (baseViewHolder instanceof AlbumHolder) {
            AlbumHolder albumHolder = (AlbumHolder) baseViewHolder;
            albumHolder.onBind(itemsModels.get(i));
        }

        if (baseViewHolder instanceof TrackHolder) {
            TrackHolder albumHolder = (TrackHolder) baseViewHolder;
            albumHolder.onBind(itemsModels.get(i));
        }
    }

    @Override
    public int getItemCount() {
        if(itemsModels != null)
           return itemsModels.size();
        return 0;

    }

    class AlbumHolder extends RecyclerView.ViewHolder {

        private ImageView albumImage;
        private TextView nameAlbumTV;
        private TextView costTV;
        private TextView trackCountTV;
        private TextView copyrightTV;


        AlbumHolder(View itemView) {
            super(itemView);

            albumImage = itemView.findViewById(R.id.albumImage);
            nameAlbumTV = itemView.findViewById(R.id.nameAlbumTV);
            costTV = itemView.findViewById(R.id.costTV);
            trackCountTV = itemView.findViewById(R.id.trackCountTV);
            copyrightTV = itemView.findViewById(R.id.copyrightTV);

        }

        public void onBind(ItemsModel itemsModel){
            Picasso.get()
                    .load(itemsModel.artworkUrl100)
                    .placeholder(android.R.drawable.ic_menu_camera)
                    .error(android.R.drawable.ic_menu_camera)
                    .into(albumImage);

            nameAlbumTV.setText(itemsModel.collectionName);
            copyrightTV.setText(itemsModel.copyright);
            trackCountTV.setText(String.format(trackCountTV.getContext().getString(R.string.count_tracks), itemsModel.trackCount));
            costTV.setText(String.format(trackCountTV.getContext().getString(R.string.cost_album), itemsModel.collectionPrice));
        }
    }

    class TrackHolder extends RecyclerView.ViewHolder {
        private TextView trackNameTV;

        TrackHolder(View itemView) {
            super(itemView);

            trackNameTV = itemView.findViewById(R.id.trackNameTV);
        }

        public void onBind(ItemsModel itemsModel){
            trackNameTV.setText(String.format("%d) %s",getAdapterPosition(),itemsModel.trackName));
        }
    }

}
