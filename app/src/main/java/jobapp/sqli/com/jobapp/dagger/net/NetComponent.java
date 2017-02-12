package jobapp.sqli.com.jobapp.dagger.net;


import javax.inject.Singleton;

import dagger.Component;
import jobapp.sqli.com.jobapp.models.DataSource;

@Singleton
@Component(modules={NetModule.class})
public interface NetComponent {
    void inject(DataSource dataSource);
}
