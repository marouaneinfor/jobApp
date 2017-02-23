package jobapp.sqli.com.jobapp.models;


import jobapp.sqli.com.jobapp.models.DataSource;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;
import jobapp.sqli.com.jobapp.pojo.Job;

public class FindItemsInteractorImpl extends DataSource<Job> implements FindItemsInteractor {


    public FindItemsInteractorImpl() {
        super(Job.class);
    }


    @Override
    public void getItems() {
        super.getItems();
    }


}