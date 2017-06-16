package com.mvvm.zzy.plusemonitorwithbluetooth.Model.Adapters;

import android.support.design.widget.TextInputLayout;

/**
 * Created by Administrator on 2017/6/16 0016.
 */

public class BindingAdapter {

    @android.databinding.BindingAdapter("ageInputErrorHint")
    public static void checkInputAge(TextInputLayout textInputLayout, String errorHint) {
        String strAge = textInputLayout.getEditText().getText().toString();
        int age = strAge.isEmpty() ? 0 : Integer.getInteger(strAge);
        if (age<0 || age>200) {
            textInputLayout.setError(errorHint);
        } else {
            textInputLayout.setError(null);
        }
    }
}
