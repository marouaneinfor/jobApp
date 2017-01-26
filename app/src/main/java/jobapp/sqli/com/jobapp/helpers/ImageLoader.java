package jobapp.sqli.com.jobapp.helpers;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import jobapp.sqli.com.jobapp.R;


public class ImageLoader {
  private Context mContext;

  public ImageLoader(Context context) {
    this.mContext = context;
  }

  public void loadImage(String url, ImageView imageView) {
    Picasso.with(this.mContext).load(url).placeholder(R.drawable.placeholder).error(R.drawable.error_placeholder)
        .into(imageView);

  }
}
