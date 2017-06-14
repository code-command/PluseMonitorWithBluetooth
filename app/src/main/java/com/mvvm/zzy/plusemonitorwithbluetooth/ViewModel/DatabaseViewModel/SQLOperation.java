package com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.DatabaseViewModel;

import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean.ErrorCode;
import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14 0014.
 */

public class SQLOperation {

    public static boolean checkLogin(User user, List<ErrorCode> list) {
        if (!checkInfoIntegrity(user, list)) {
            return false;
        }
        return true;
    }

    private static boolean checkInfoIntegrity(User user, List<ErrorCode> list) {
        if (user.getName()==null || user.getName().isEmpty()) {
            list.add(ErrorCode.EMPTY_USER_NAME);
            return false;
        }
        if (user.getPassword()==null || user.getPassword().isEmpty()) {
            list.add(ErrorCode.EMPTY_USER_PWD);
            return false;
        }
        return true;
    }
}
