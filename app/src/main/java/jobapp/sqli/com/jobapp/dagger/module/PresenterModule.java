package jobapp.sqli.com.jobapp.dagger.module;

import dagger.Module;
import dagger.Provides;
import jobapp.sqli.com.jobapp.presenter.MainPresenter;
import jobapp.sqli.com.jobapp.presenter.MainPresenterImpl;
import jobapp.sqli.com.jobapp.views.MainView;



@Module
public class PresenterModule {
    private MainView mainView;

    public PresenterModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    MainPresenter provideMainPresenter() {
        return new MainPresenterImpl(mainView);
    }

}
