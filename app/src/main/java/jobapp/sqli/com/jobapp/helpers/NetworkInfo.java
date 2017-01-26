package jobapp.sqli.com.jobapp.helpers;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

import jobapp.sqli.com.jobapp.MainView;

public class NetworkInfo {
  public static boolean isNetworkAvailable(MainView mainView) {
    Activity activity = (Activity) mainView;
    ConnectivityManager connectivityManager = (ConnectivityManager) activity
        .getSystemService
            (Context.CONNECTIVITY_SERVICE);
    android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null;
  }
}
