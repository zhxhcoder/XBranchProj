package com.zhxh.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.zhxh.modulebase.service.IAccountService;

public class AccountService implements IAccountService {
    @Override
    public boolean isLogin() {
        return UserManager.userInfo != null;
    }

    @Override
    public String getAccountId() {
        return UserManager.userInfo == null ? null : UserManager.userInfo.getAccountId();
    }

    @Override
    public Fragment newUserFragment(Activity activity, int containerId, FragmentManager manager, Bundle bundle, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment userFragment = new UserFragment();
        transaction.add(containerId, userFragment, tag);
        transaction.commit();
        return userFragment;
    }
}
