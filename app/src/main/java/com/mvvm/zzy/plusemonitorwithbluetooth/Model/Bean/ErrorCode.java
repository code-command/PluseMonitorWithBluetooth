package com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean;

import com.mvvm.zzy.plusemonitorwithbluetooth.R;

/**
 * Created by Administrator on 2017/6/14 0014.
 */

public enum ErrorCode {
    EMPTY_USER_NAME(R.string.login_emptyNameHint),
    EMPTY_USER_PWD(R.string.login_emptyPwdHint),
    EMPTY_USER_LOGINFAILUER(R.string.login_failuerLogin);

    private int index;
    ErrorCode(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
