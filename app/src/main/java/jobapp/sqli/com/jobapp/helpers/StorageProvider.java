package jobapp.sqli.com.jobapp.helpers;


import java.util.List;
import io.realm.Realm;
import io.realm.RealmObject;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;


public class StorageProvider {
    private Realm realm;

    public StorageProvider() {
        this.realm = Realm.getDefaultInstance();
    }


    public <T  extends RealmObject> void saveItems(List<T> list, Class<T> tClass) {
        for (T object : list) {
            realm.beginTransaction();
            object=realm.copyToRealm(object);
            realm.commitTransaction();
        }
    }



    public  <T  extends RealmObject>  List<T> getItems(Class<T> tClass) {
        return realm.copyFromRealm(realm.where(tClass).findAll());
    }


}
