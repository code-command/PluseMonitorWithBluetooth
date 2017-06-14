package com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.ButtonViewModel;

import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean.ErrorCode;

/**
 * Created by Administrator on 2017/6/14 0014.
 */

public interface OnGetClickListener {
    public void success();
    public void failure(ErrorCode errorCode);
}
