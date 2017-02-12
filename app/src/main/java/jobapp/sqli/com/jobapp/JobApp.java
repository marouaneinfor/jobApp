package jobapp.sqli.com.jobapp;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;


public class JobApp extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initRealMConfig();

    }

    private void initRealMConfig() {
        Realm.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
