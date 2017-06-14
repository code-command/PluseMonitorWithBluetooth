package com.mvvm.zzy.plusemonitorwithbluetooth.View.Activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean.User;
import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Widget.OptimizationToast;
import com.mvvm.zzy.plusemonitorwithbluetooth.R;
import com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.ButtonViewModel.LoginButtonViewModel;
import com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.ButtonViewModel.OnGetClickListener;
import com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.MethodsViewModel.ActionBarOperation;
import com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.MethodsViewModel.HideSoftKeyBoard;
import com.mvvm.zzy.plusemonitorwithbluetooth.ViewModel.MethodsViewModel.ImmersionLine;
import com.mvvm.zzy.plusemonitorwithbluetooth.databinding.ActionbarLoginBinding;
import com.mvvm.zzy.plusemonitorwithbluetooth.databinding.ActivityLoginBinding;

import java.lang.ref.WeakReference;

public class LoginActivity extends AppCompatActivity {

    private User user;
    private LoginButtonViewModel loginButtonViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        super.onCreate(savedInstanceState);
        new ImmersionLine(this, R.color.actionBarBackground);
        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        initActionBar();
        initData();
        bindingData();
    }


    private void initActionBar() {
        HideSoftKeyBoard.setupUI(binding.loginRlRoot, this);
        initCustomActionBar();
    }

    private void initCustomActionBar() {
        ActionBarOperation.setSystemActionBar(getApplicationContext(), this.getSupportActionBar(), R.color.actionBarBackground);
        ViewGroup root = (ViewGroup) findViewById(R.id.ablogin_root);
        ActionbarLoginBinding custonActionBar = DataBindingUtil.inflate(getLayoutInflater(), R.layout.actionbar_login, root, false);
        custonActionBar.abloginTitle.setText(getString(R.string.login_login));
        custonActionBar.abloginRightImbtn.setVisibility(View.VISIBLE);
        custonActionBar.abloginRightImbtn.setText(R.string.login_register);
        custonActionBar.abloginRightImbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OptimizationToast.showToast(new WeakReference<Context>(getApplication()), "Go to RegisterActivity");
            }
        });
        this.getSupportActionBar().setCustomView(custonActionBar.abloginRoot);
    }

    private void initData() {
        user = new User();
        loginButtonViewModel = new LoginButtonViewModel(user);
        loginButtonViewModel.setOnClickListener(new OnGetClickListener() {
            @Override
            public void success() {
                OptimizationToast.showToast(new WeakReference<Context>(getApplication()), "Go to WorkActivity");
            }

            @Override
            public void failure() {
                OptimizationToast.showToast(new WeakReference<Context>(getApplication()), getString(R.string.login_errorLogin));
            }
        });

    }

    private void bindingData() {
        binding.setUser(user);
        binding.setLoginViewModel(loginButtonViewModel);
    }
}

