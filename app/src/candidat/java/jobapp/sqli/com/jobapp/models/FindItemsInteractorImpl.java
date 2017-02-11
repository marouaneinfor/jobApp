package jobapp.sqli.com.jobapp.models;


public class FindItemsInteractorImpl extends DataSource implements FindItemsInteractor {


    public FindItemsInteractorImpl() {
        super();
    }


    @Override
    public void getItems() {
        super.requestCandidats();

    }


}