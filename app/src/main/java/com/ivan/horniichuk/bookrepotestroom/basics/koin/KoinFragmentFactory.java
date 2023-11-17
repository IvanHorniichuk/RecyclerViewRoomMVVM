package com.ivan.horniichuk.bookrepotestroom.basics.koin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.ivan.horniichuk.bookrepotestroom.basics.mvvm.BaseFragment;
import com.ivan.horniichuk.signature.statistic.basics.koin.JavaKoin;


public class KoinFragmentFactory extends FragmentFactory {

    private final String TAG = "KoinFragmentFactory";
    private final Class<BaseFragment> baseFragmentClass = BaseFragment.class;
    //private final Class<PreferenceFragmentCompat> preferenceFragmentCompatClass=PreferenceFragmentCompat.class;
    private final AppCompatActivity activity;

    public KoinFragmentFactory(AppCompatActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Class clazz = loadFragmentClass(classLoader, className);
        if (baseFragmentClass.isAssignableFrom(clazz)) //||preferenceFragmentCompatClass.isAssignableFrom(clazz))
            return JavaKoin.scopeOf(activity).get(clazz);
        else
            return super.instantiate(classLoader, className);
    }
}