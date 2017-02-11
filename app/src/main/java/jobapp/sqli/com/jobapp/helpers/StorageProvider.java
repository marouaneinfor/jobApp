package jobapp.sqli.com.jobapp.helpers;


import java.util.List;
import io.realm.Realm;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;


public class StorageProvider {
    private Realm realm;

    public StorageProvider() {
        this.realm = Realm.getDefaultInstance();
    }


    public void saveJobs(List<Job> jobs) {
        for (Job job : jobs) {
            realm.beginTransaction();
            Job tmpJob = realm.createObject(Job.class);
            tmpJob.copy(job);
            realm.commitTransaction();
        }
    }

    public void saveCandidats(List<Candidat> candidats) {
        for (Candidat candidat : candidats) {
            realm.beginTransaction();
            Candidat tmpCandidat = realm.createObject(Candidat.class);
            tmpCandidat.copy(candidat);
            realm.commitTransaction();
        }
    }

    public List<Candidat> getCandidats() {
        return realm.copyFromRealm(realm.where(Candidat.class).findAll());
    }

    public List<Job> getJobs() {
        return realm.copyFromRealm(realm.where(Job.class).findAll());
    }
}
