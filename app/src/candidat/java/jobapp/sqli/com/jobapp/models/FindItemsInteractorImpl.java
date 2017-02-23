package jobapp.sqli.com.jobapp.models;


import jobapp.sqli.com.jobapp.pojo.Candidat;

public class FindItemsInteractorImpl extends DataSource<Candidat> implements FindItemsInteractor {


    public FindItemsInteractorImpl() {
        super(Candidat.class);
    }


    @Override
    public void getItems() {
        super.getItems();

    }


}