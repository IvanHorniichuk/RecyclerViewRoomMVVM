package com.ivan.horniichuk.bookrepotestroom;



import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.lifecycle.LifecycleObserver;

public class Application extends android.app.Application implements LifecycleObserver {

    public static final String TAG = "StatisticApplication";

    @Override
    public void onCreate() {
        super.onCreate();
      //  startKoinApplication(this);

    }

    public void restartApplication() {
        PackageManager packageManager = getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(getPackageName());
        if (intent != null) {
            ComponentName componentName = intent.getComponent();
            Intent mainIntent = Intent.makeRestartActivityTask(componentName);
            startActivity(mainIntent);
            System.exit(0);
        }
    }
}