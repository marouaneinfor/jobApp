

package jobapp.sqli.com.jobapp.models;

import java.util.List;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;

public interface FindItemsInteractor {

    interface OnFinishedListener {
        void onDataLoaded(List<Object> data);

        @SuppressWarnings("unused")
        void onDataFailed();



    }

    void getItems();



    void addListener(FindItemsInteractor.OnFinishedListener listener);

    @SuppressWarnings("unused")
    void removeListener(FindItemsInteractor.OnFinishedListener listener);

}
