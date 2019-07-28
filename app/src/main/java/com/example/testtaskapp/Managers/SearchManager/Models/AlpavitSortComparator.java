package com.example.testtaskapp.Managers.SearchManager.Models;

import java.util.Comparator;

public class AlpavitSortComparator implements Comparator<ItemsModel> {

    public int compare(ItemsModel i1, ItemsModel i2) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(i1.collectionName, i2.collectionName);
        if (res == 0) {
            res = i1.collectionName.compareTo(i2.collectionName);
        }
        return res;
    }
}
