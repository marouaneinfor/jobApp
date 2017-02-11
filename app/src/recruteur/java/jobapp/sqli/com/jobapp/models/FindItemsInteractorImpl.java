package jobapp.sqli.com.jobapp.models;


import jobapp.sqli.com.jobapp.models.DataSource;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;

public class FindItemsInteractorImpl extends DataSource implements FindItemsInteractor {


    public FindItemsInteractorImpl() {
        super();
    }


    @Override
    public void getItems() {
        super.requestJobs();
    }


}