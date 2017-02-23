package jobapp.sqli.com.jobapp.models;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmObject;
import jobapp.sqli.com.jobapp.dagger.module.NetModule;
import jobapp.sqli.com.jobapp.helpers.NetworkInfo;
import jobapp.sqli.com.jobapp.helpers.StorageProvider;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DataSource<T extends RealmObject> implements FindItemsInteractor {

    private ArrayList<OnFinishedListener> listeners = new ArrayList<>();
    @Inject
    StorageProvider mStorageProvider;
    private FindItemsService mService;
    @Inject
    Retrofit retrofit;
    private Class<T> mtClass;

    public DataSource(Class<T> tClass) {
        this();
        this.mtClass = tClass;
    }

    public DataSource() {
        mService = retrofit.create(FindItemsService.class);
    }


    public void getItems() {
        if (NetworkInfo.isNetworkAvailable()) {
            Observable<List<T>> call = mService.requestItems();
            call.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(mJobs -> {
                        mStorageProvider.saveItems(mJobs, mtClass);
                        for (OnFinishedListener listener : listeners) {
                            listener.onDataLoaded(new ArrayList<Object>(mJobs));
                        }
                    });
        } else {
            for (OnFinishedListener listener : listeners) {
                listener.onDataLoaded(new ArrayList<Object>(mStorageProvider.getItems(mtClass)));
            }
        }
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