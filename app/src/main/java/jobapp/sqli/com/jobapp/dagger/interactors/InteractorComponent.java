package jobapp.sqli.com.jobapp.dagger.interactors;

import javax.inject.Singleton;

import dagger.Component;
import jobapp.sqli.com.jobapp.presenter.MainPresenterImpl;


@Singleton
@Component(modules={InteractorModule.class})
public interface InteractorComponent {
    void inject(MainPresenterImpl mainPresenter);

}
