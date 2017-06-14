package com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.ButtonViewModel;

import android.view.View;

import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean.User;
import com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.DatabaseViewModel.SQLOperation;

/**
 * Created by Administrator on 2017/6/14 0014.
 */

public class LoginButtonViewModel extends ButtonViewModel {

    private User user;
    private OnGetClickListener onClickListener;

    public LoginButtonViewModel(User user) {
        this.user = user;
    }

    @Override
    public void buttonChangedListener(View view) {
        if (SQLOperation.checkLogin(user)) {
            onClickListener.success();
        } else {
            onClickListener.failure();
        }
    }

    public void setOnClickListener(OnGetClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
