package com.example.testtaskapp.Managers.SearchManager.Models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Comparator;

public class ItemsModel implements Serializable, Comparator<ItemsModel> {

    @SerializedName("wrapperType")
    @Expose
    public String wrapperType;
    @SerializedName("collectionType")
    @Expose
    public String collectionType;
    @SerializedName("artistId")
    @Expose
    public Integer artistId;
    @SerializedName("collectionId")
    @Expose
    public Integer collectionId;
    @SerializedName("amgArtistId")
    @Expose
    public Integer amgArtistId;
    @SerializedName("artistName")
    @Expose
    public String artistName;
    @SerializedName("collectionName")
    @Expose
    public String collectionName;
    @SerializedName("collectionCensoredName")
    @Expose
    public String collectionCensoredName;
    @SerializedName("artistViewUrl")
    @Expose
    public String artistViewUrl;
    @SerializedName("collectionViewUrl")
    @Expose
    public String collectionViewUrl;
    @SerializedName("artworkUrl60")
    @Expose
    public String artworkUrl60;
    @SerializedName("artworkUrl100")
    @Expose
    public String artworkUrl100;
    @SerializedName("collectionPrice")
    @Expose
    public Double collectionPrice;
    @SerializedName("collectionExplicitness")
    @Expose
    public String collectionExplicitness;
    @SerializedName("trackCount")
    @Expose
    public Integer trackCount;
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;
    @SerializedName("primaryGenreName")
    @Expose
    public String primaryGenreName;
    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("trackId")
    @Expose
    public Integer trackId;
    @SerializedName("trackName")
    @Expose
    public String trackName;
    @SerializedName("trackCensoredName")
    @Expose
    public String trackCensoredName;
    @SerializedName("trackViewUrl")
    @Expose
    public String trackViewUrl;
    @SerializedName("previewUrl")
    @Expose
    public String previewUrl;
    @SerializedName("artworkUrl30")
    @Expose
    public String artworkUrl30;
    @SerializedName("trackPrice")
    @Expose
    public Double trackPrice;
    @SerializedName("trackExplicitness")
    @Expose
    public String trackExplicitness;
    @SerializedName("discCount")
    @Expose
    public Integer discCount;
    @SerializedName("discNumber")
    @Expose
    public Integer discNumber;
    @SerializedName("trackNumber")
    @Expose
    public Integer trackNumber;
    @SerializedName("trackTimeMillis")
    @Expose
    public Integer trackTimeMillis;
    @SerializedName("isStreamable")
    @Expose
    public Boolean isStreamable;


    @Override
    public int compare(ItemsModel item1, ItemsModel item2) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(item1.collectionName, item2.collectionName);
        if (res == 0) {
            res = item1.collectionName.compareTo(item1.collectionName);
        }
        return res;
    }


}
