package com.bst.veggiesoft.utilities;

import android.content.Context;
import android.os.Environment;

import java.util.Date;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * Created by ringmd on 12/10/18.
 */

public class LogUtility {
    private final static LogConfigurator mLogConfigrator = new LogConfigurator();

    static {

    }

    public static void configureLog4j(Context context) {
        try {
            String fileName = context.getExternalFilesDir("logs").getAbsolutePath() + "/" + DataUtility.mmmddyyyyToString(new Date()) + ".log";
            String filePattern = "%d - [%c] - %p : %m%n";
            int maxBackupSize = 10;
            long maxFileSize = 10 * 1024 * 1024;

            configure(fileName, filePattern, maxBackupSize, maxFileSize);
        } catch (Exception e) {

        }
    }

    private static void configure(String fileName, String filePattern, int maxBackupSize, long maxFileSize) {
        mLogConfigrator.setFileName(fileName);
        mLogConfigrator.setUseFileAppender(true);
        mLogConfigrator.setMaxFileSize(maxFileSize);
        mLogConfigrator.setFilePattern(filePattern);
        mLogConfigrator.setMaxBackupSize(maxBackupSize);
        mLogConfigrator.setUseLogCatAppender(true);
        mLogConfigrator.configure();
    }

}
