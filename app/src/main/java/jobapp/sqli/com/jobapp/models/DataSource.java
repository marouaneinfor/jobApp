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
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DataSource implements FindItemsInteractor {

    private ArrayList<OnFinishedListener> listeners = new ArrayList<>();
    @Inject
    StorageProvider mStorageProvider;
    private FindItemsService mService;
    @Inject
    Retrofit retrofit;

    public DataSource() {
        DaggerNetComponent.builder().netModule(new NetModule()).build().inject(this);
        mService = retrofit.create(FindItemsService.class);
    }

    protected void requestJobs() {
        if (NetworkInfo.isNetworkAvailable()) {
            Observable<List<Job>> call = mService.requestJobs();
            call.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(mJobs -> {
                        mStorageProvider.saveJobs(mJobs);
                        for (OnFinishedListener listener : listeners) {
                            listener.onDataLoaded(new ArrayList<Object>(mJobs));
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
            Observable<List<Candidat>> call = mService.requestCandidats();
            call.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(mCandidat -> {
                        mStorageProvider.saveCandidats(mCandidat);
                        for (OnFinishedListener listener : listeners) {
                            listener.onDataLoaded(new ArrayList<Object>(mCandidat));
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
        //TODO
    }

    @SuppressWarnings("unused")
    public void addListener(OnFinishedListener listener) {
        listeners.add(listener);
    }

    @SuppressWarnings("unused")
    public void removeListener(OnFinishedListener listener) {
        listeners.remove(listener);
    }


}