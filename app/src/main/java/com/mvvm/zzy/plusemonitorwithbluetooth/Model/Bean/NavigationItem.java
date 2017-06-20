package com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mvvm.zzy.plusemonitorwithbluetooth.BR;


/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class NavigationItem extends BaseObservable {

    private String itemName;
    private int iconResourceId;

    public NavigationItem() {

    }

    public NavigationItem(String itemName, int iconResourceId) {
        this.itemName = itemName;
        this.iconResourceId = iconResourceId;
    }

    @Bindable
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
        notifyPropertyChanged(BR.itemName);
    }

    @Bindable
    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
        notifyPropertyChanged(BR.iconResourceId);
    }
}
