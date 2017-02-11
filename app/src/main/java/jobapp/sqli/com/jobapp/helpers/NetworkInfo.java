package jobapp.sqli.com.jobapp.helpers;


import android.content.Context;
import android.net.ConnectivityManager;
import jobapp.sqli.com.jobapp.JobApp;

public class NetworkInfo {
  public static boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager = (ConnectivityManager) JobApp.getContext()
        .getSystemService
            (Context.CONNECTIVITY_SERVICE);
    android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null;
  }
}
