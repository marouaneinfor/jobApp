package jobapp.sqli.com.jobapp.model;

import java.util.ArrayList;
import java.util.List;

import jobapp.sqli.com.jobapp.BuildConfig;
import jobapp.sqli.com.jobapp.MainView;
import jobapp.sqli.com.jobapp.helpers.NetworkInfo;
import jobapp.sqli.com.jobapp.helpers.StorageProvider;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindItemsInteractorImpl implements FindItemsInteractor {

  private ArrayList<FindItemsInteractor.OnFinishedListener> listeners = new ArrayList<>();


  private List<Job> mJobs = new ArrayList<>();
  private List<Candidat> mCandidat = new ArrayList<>();
  private StorageProvider mStorageProvider;
  private MainView mainView;
  private FindItemsService service;


  public FindItemsInteractorImpl(MainView mainView) {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel
        (HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
        .build();
    service = retrofit.create(FindItemsService.class);
    this.mainView = mainView;
    this.mStorageProvider = new StorageProvider(mainView);
  }

  public void requestJobs() {

    if (NetworkInfo.isNetworkAvailable(this.mainView)) {
      final Call<List<Job>> call = service.requestJobs();
      call.enqueue(new Callback<List<Job>>() {
        @Override
        public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
          if (response.isSuccessful()) {
            mJobs = response.body();
            mStorageProvider.saveJobs(mJobs);
            for (FindItemsInteractor.OnFinishedListener listener : listeners) {
              listener.onJobsLoaded(mJobs);
            }
          } else {
            for (FindItemsInteractor.OnFinishedListener listener : listeners) {
              listener.onJobsLoadFailed();
            }
          }
        }

        @Override
        public void onFailure(Call<List<Job>> call, Throwable t) {
          for (FindItemsInteractor.OnFinishedListener listener : listeners) {
            listener.onJobsLoadFailed();
          }
        }

      });
    } else {

      for (FindItemsInteractor.OnFinishedListener listener : listeners) {
        listener.onJobsLoaded(mStorageProvider.getJobs());
      }

    }
  }


  public void requestCandidats() {

    if (NetworkInfo.isNetworkAvailable(this.mainView)) {

      final Call<List<Candidat>> call = service.requestCandidats();
      call.enqueue(new Callback<List<Candidat>>() {
        @Override
        public void onResponse(Call<List<Candidat>> call, Response<List<Candidat>> response) {
          if (response.isSuccessful()) {
            mCandidat = response.body();
            mStorageProvider.saveCandidats(mCandidat);
            for (FindItemsInteractor.OnFinishedListener listener : listeners) {
              listener.onCandidatsLoaded(mCandidat);
            }
          } else {
            for (FindItemsInteractor.OnFinishedListener listener : listeners) {
              listener.onCandidatsFailed();
            }
          }
        }

        @Override
        public void onFailure(Call<List<Candidat>> call, Throwable t) {
          for (FindItemsInteractor.OnFinishedListener listener : listeners) {
            listener.onJobsLoadFailed();
          }
        }

      });
    } else {

      for (FindItemsInteractor.OnFinishedListener listener : listeners) {
        listener.onCandidatsLoaded(mStorageProvider.getCandidats());
      }

    }
  }

  @Override
  public void requestCandidatsAndJobs() {
    requestJobs();
    requestCandidats();
  }

  public void addListener(FindItemsInteractor.OnFinishedListener listener) {
    listeners.add(listener);
  }

  public void removeListener(FindItemsInteractor.OnFinishedListener listener) {
    listeners.remove(listener);
  }


}