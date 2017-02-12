package jobapp.sqli.com.jobapp.helpers;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import jobapp.sqli.com.jobapp.JobApp;
import jobapp.sqli.com.jobapp.R;


public class ImageLoader {

  public static void loadImage(String url, ImageView imageView) {
    Picasso.with(JobApp.getContext()).load(url).placeholder(R.drawable.placeholder).error(R.drawable.error_placeholder)
        .into(imageView);

  }
}
