package com.bst.veggiesoft.activities;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bst.veggiesoft.R;
import com.bst.veggiesoft.utilities.LogUtility;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;

import org.apache.log4j.Logger;

import gr.net.maroulis.library.EasySplashScreen;
import io.fabric.sdk.android.BuildConfig;
import io.fabric.sdk.android.Fabric;


public class SplashActivity extends AppCompatActivity {

    private static Logger log = Logger.getLogger(SplashActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        PackageInfo pInfo = null;
        String version = "";
        try {
            pInfo = SplashActivity.this.getPackageManager().getPackageInfo(SplashActivity.this.getPackageName(), 0);
            version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        EasySplashScreen easySplashScreenConfig = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(DeviceSelectionActivity.class)
                .withSplashTimeOut(4000)
                .withLogo(R.drawable.bst_logo)
                .withFooterText("Version " + version);

        easySplashScreenConfig.getFooterTextView().setTextColor(Color.WHITE);
        easySplashScreenConfig.getFooterTextView().setShadowLayer(1.5f, 2, 2, Color.BLACK);
        View easySplashScreenView = easySplashScreenConfig.create();

        setContentView(easySplashScreenView);
    }
}
