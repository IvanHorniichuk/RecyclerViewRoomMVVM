package com.ivan.horniichuk.bookrepotestroom.basics.mvvm;

import static com.ivan.horniichuk.signature.statistic.basics.koin.JavaKoin.closeKoinApplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ivan.horniichuk.signature.statistic.basics.koin.JavaKoin;

import org.koin.core.scope.Scope;
import org.koin.java.KoinJavaComponent;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    private final String TAG = "BaseActivity";
    private Scope scope;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void createScope() {
        if (scope == null) {
            scope = JavaKoin.createScopeWithContext(this);
        }
    }

    protected void disposeScope() {
        if (scope != null) {
            scope.close();
            scope = null;
        }
    }

    protected void closeKoinApp() {
        closeKoinApplication();
    }

    protected <T> T instanceOf(Class<T> componentClass) {
        T result;
        if (scope != null) {
            result = scope.get(componentClass);
        } else {
            result = KoinJavaComponent.get(componentClass);
        }
        return result;
    }

    protected void hideNavigationBar() {
        getSupportActionBar().hide();
    }
}
