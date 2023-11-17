package com.ivan.horniichuk.bookrepotestroom.basics;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ivan.horniichuk.signature.statistic.R;

public class BaseNavigator {

    public static final String TAG = "NavControllerNavigator";

    protected NavController navController;
    protected final AppCompatActivity activity;
    protected int originalSoftInputMode;

    public BaseNavigator(AppCompatActivity activity) {
        this.activity = activity;
        tryToInit();
    }

    public void tryToInit() {
        try {
            navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean isInited() {
        if (navController == null) {
            tryToInit();
        }
        return navController != null;
    }

    public void navigateBack() {
        if (isInited()) {
            setClickable(true);
            hideKeyboard();
            navController.navigateUp();
        }
    }

    public void finishActivity() {
        if (activity != null)
            activity.finish();
    }

    public void finishApplication() {
        activity.finishAffinity();
        System.exit(0);

        //activity.moveTaskToBack(true);
        //activity.finish();
    }

    public void restartApplication() {
        PackageManager packageManager = activity.getApplicationContext().getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(activity.getApplicationContext().getPackageName());
        if (intent != null) {
            ComponentName componentName = intent.getComponent();
            Intent mainIntent = Intent.makeRestartActivityTask(componentName);
            activity.getApplicationContext().startActivity(mainIntent);
            System.exit(0);
        }
    }

    public void setClickable(boolean value) {
        if (!value) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void changeResizeInputMode(boolean toResize) {
        if (activity != null) {
            if (toResize) {
                this.originalSoftInputMode = activity.getWindow().getAttributes().softInputMode;
                activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            } else {
                activity.getWindow().setSoftInputMode(originalSoftInputMode);
            }
        }
    }


}
