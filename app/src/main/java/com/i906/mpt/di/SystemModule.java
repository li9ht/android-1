package com.i906.mpt.di;

import android.app.AlarmManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Vibrator;
import android.support.v4.app.NotificationManagerCompat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SystemModule {

    private Application mContext;

    public SystemModule(Application application) {
        mContext = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public PackageManager providePackageManager() {
        return mContext.getPackageManager();
    }

    @Provides
    @Singleton
    public LocationManager provideLocationManager() {
        return (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    public AlarmManager provideAlarmManager() {
        return (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
    }

    @Provides
    @Singleton
    public NotificationManagerCompat providesNotificationManager() {
        return NotificationManagerCompat.from(mContext);
    }

    @Provides
    @Singleton
    public Vibrator providesVibrator() {
        return (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
    }
}
