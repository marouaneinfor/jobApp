package jobapp.sqli.com.jobapp.helpers;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import jobapp.sqli.com.jobapp.JobApp;
import jobapp.sqli.com.jobapp.R;


public class ImageLoader {
  private ImageView mView;

  public ImageLoader(ImageView mImageView) {
    this.mView = mImageView;
  }

  public  void loadImage(String mUrl) {
    Picasso.with(mView.getContext()).load(mUrl).placeholder(R.drawable.placeholder).error(R.drawable.error_placeholder)
        .into(mView);

  }
}
