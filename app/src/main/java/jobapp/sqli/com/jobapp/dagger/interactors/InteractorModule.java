package jobapp.sqli.com.jobapp.dagger.interactors;



import dagger.Module;
import dagger.Provides;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;
import jobapp.sqli.com.jobapp.models.FindItemsInteractorImpl;

@Module
public class InteractorModule {

    @Provides
    FindItemsInteractor provideInteractor() {
        return new FindItemsInteractorImpl();
    }

}
