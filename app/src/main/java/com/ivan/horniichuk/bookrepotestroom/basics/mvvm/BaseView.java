package com.ivan.horniichuk.bookrepotestroom.basics.mvvm;

import android.content.Context;
import android.view.View;

public class BaseView {
    protected View viewLayout;

    public View getViewLayout() {
        return viewLayout;
    }

    public Context getContext() {
        if (viewLayout != null)
            return viewLayout.getContext();
        return null;
    }

}
