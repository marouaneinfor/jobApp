package jobapp.sqli.com.jobapp.dagger.presenters;


import javax.inject.Singleton;

import dagger.Component;
import jobapp.sqli.com.jobapp.views.MainActivity;

@Singleton
@Component(modules={PresenterModule.class})
public interface PresenterComponent {
    void inject(MainActivity mainView);

}
