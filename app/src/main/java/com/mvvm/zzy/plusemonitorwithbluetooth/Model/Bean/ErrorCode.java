package com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean;

import com.mvvm.zzy.plusemonitorwithbluetooth.R;

/**
 * Created by Administrator on 2017/6/14 0014.
 */

public enum ErrorCode {
    EMPTY_USERNAME(R.string.login_emptyNameHint),
    EMPTY_USERPWD(R.string.login_emptyPwdHint),
    USER_LOGINFAILURE(R.string.login_failuerLogin),

    USERNAME_NOTUNIQUE(R.string.register_username_notunique),
    USERPWD_ERRORFORMAT(R.string.register_userpwd_errorformat),
    USERPWD_DISAFFINITY(R.string.register_userpwd_disaffinity),
    USERAGE_OUTRANGE(R.string.register_age_outrange),
    REGISTER_SAVEFAILURE(R.string.register_savefailure),


    ENDMARK(Integer.MAX_VALUE);
    private int index;
    ErrorCode(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
