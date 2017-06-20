package com.mvvm.zzy.plusemonitorwithbluetooth.View.Fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvvm.zzy.plusemonitorwithbluetooth.BR;
import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Adapters.ListAdapter;
import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean.NavigationItem;
import com.mvvm.zzy.plusemonitorwithbluetooth.Model.Bean.User;
import com.mvvm.zzy.plusemonitorwithbluetooth.R;
import com.mvvm.zzy.plusemonitorwithbluetooth.databinding.FragmentNavigationBinding;

import java.util.ArrayList;
import java.util.List;

public class NavigationFragment extends Fragment {

    private FragmentNavigationBinding binding;
    private List<NavigationItem> itemList = new ArrayList<>();
    private ListAdapter itemListAdapter;

    private User user;

    public static NavigationFragment newInstance(User user) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        NavigationFragment navigationFragment = new NavigationFragment();
        navigationFragment.setArguments(bundle);
        return navigationFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_navigation, container, false);
        initData(savedInstanceState);
        setBinding();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initData(Bundle savedInstanceState) {
        initItemList();
        itemListAdapter = new ListAdapter(this.getActivity(), R.layout.activity_home_navigation_item, BR.navigationItem, itemList);
        Bundle bundle = getArguments();
        if (bundle != null) {
            user = (User)bundle.getSerializable("user");
        }
    }

    private void initItemList() {
        for (int i = 0; i < getResources().getStringArray(R.array.navigation_optitem_name).length; i++) {
            NavigationItem item = new NavigationItem();
            item.setItemName(getResources().getStringArray(R.array.navigation_optitem_name)[i].toString());
            item.setIconResourceId(getResources().obtainTypedArray(R.array.navigation_optionitem_icon).getResourceId(i, 0));
            itemList.add(item);
        }
    }

    private void setBinding() {
        binding.setAdapter(itemListAdapter);
        binding.setUser(user);
    }
}
