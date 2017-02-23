package jobapp.sqli.com.jobapp.dagger.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.helpers.StorageProvider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {


    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel
                (HttpLoggingInterceptor.Level.BODY);
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JobConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    StorageProvider provideStorage() {
        return new StorageProvider();
    }
}
