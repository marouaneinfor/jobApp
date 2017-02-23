

package jobapp.sqli.com.jobapp.models;

import java.util.List;


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
