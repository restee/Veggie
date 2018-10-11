package com.bst.veggiesoft.application;

import android.content.res.Configuration;

import com.bst.veggiesoft.utilities.LogUtility;
import com.crashlytics.android.Crashlytics;
import com.orm.SugarApp;

import io.fabric.sdk.android.Fabric;

/**
 * Created by ringmd on 12/10/18.
 */

public class VeggieApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtility.configureLog4j(this);

    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
