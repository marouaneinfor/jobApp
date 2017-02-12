package jobapp.sqli.com.jobapp.models;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jobapp.sqli.com.jobapp.dagger.net.DaggerNetComponent;
import jobapp.sqli.com.jobapp.dagger.net.NetModule;
import jobapp.sqli.com.jobapp.helpers.NetworkInfo;
import jobapp.sqli.com.jobapp.helpers.StorageProvider;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataSource implements FindItemsInteractor {

    private ArrayList<OnFinishedListener> listeners = new ArrayList<>();


    private List<Job> mJobs = new ArrayList<>();
    private List<Candidat> mCandidat = new ArrayList<>();
    private StorageProvider mStorageProvider;
    private FindItemsService mService;
    @Inject
    Retrofit retrofit;

    public DataSource() {
        DaggerNetComponent.builder().netModule(new NetModule()).build().inject(this);
        mService = retrofit.create(FindItemsService.class);
        this.mStorageProvider = new StorageProvider();
    }

    protected void requestJobs() {
        if (NetworkInfo.isNetworkAvailable()) {
            final Call<List<Job>> call = mService.requestJobs();
            call.enqueue(new Callback<List<Job>>() {
                @Override
                public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                    if (response.isSuccessful()) {
                        mJobs = response.body();
                        mStorageProvider.saveJobs(mJobs);
                        for (OnFinishedListener listener : listeners) {
                            listener.onDataLoaded(new ArrayList<Object>(mJobs));
                        }
                    } else {
                        for (OnFinishedListener listener : listeners) {
                            listener.onDataFailed();
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Job>> call, Throwable t) {
                    for (OnFinishedListener listener : listeners) {
                        listener.onDataFailed();
                    }
                }

            });
        } else {

            for (OnFinishedListener listener : listeners) {
                listener.onDataLoaded(new ArrayList<Object>(mStorageProvider.getJobs()));
            }

        }
    }


    protected void requestCandidats() {

        if (NetworkInfo.isNetworkAvailable()) {

            final Call<List<Candidat>> call = mService.requestCandidats();
            call.enqueue(new Callback<List<Candidat>>() {
                @Override
                public void onResponse(Call<List<Candidat>> call, Response<List<Candidat>> response) {
                    if (response.isSuccessful()) {
                        mCandidat = response.body();
                        mStorageProvider.saveCandidats(mCandidat);
                        for (OnFinishedListener listener : listeners) {
                            listener.onDataLoaded(new ArrayList<Object>(mCandidat));
                        }
                    } else {
                        for (OnFinishedListener listener : listeners) {
                            listener.onDataFailed();
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Candidat>> call, Throwable t) {
                    for (OnFinishedListener listener : listeners) {
                        listener.onDataFailed();
                    }
                }

            });
        } else {

            for (OnFinishedListener listener : listeners) {
                listener.onDataLoaded(new ArrayList<Object>(mStorageProvider.getCandidats()));
            }

        }
    }


    @Override
    public void getItems() {

    }

    public void addListener(OnFinishedListener listener) {
        listeners.add(listener);
    }

    public void removeListener(OnFinishedListener listener) {
        listeners.remove(listener);
    }


}