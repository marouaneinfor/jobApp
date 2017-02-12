package jobapp.sqli.com.jobapp.dagger.net;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jobapp.sqli.com.jobapp.constants.JobConstants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
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
                .build();
        return retrofit;
    }
}
