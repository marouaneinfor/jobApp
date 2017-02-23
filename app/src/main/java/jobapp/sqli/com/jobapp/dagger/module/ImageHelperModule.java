package jobapp.sqli.com.jobapp.dagger.module;

import android.widget.ImageView;

import dagger.Module;
import dagger.Provides;
import jobapp.sqli.com.jobapp.helpers.ImageLoader;


@Module

public class ImageHelperModule {
    private ImageView mImageView;

    public ImageHelperModule(ImageView mImageView) {
        this.mImageView = mImageView;
    }

    @Provides
    ImageLoader provideImageLoader() {
        return new ImageLoader(mImageView);
    }
}


