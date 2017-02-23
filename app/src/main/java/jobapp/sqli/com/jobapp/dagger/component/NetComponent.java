package jobapp.sqli.com.jobapp.dagger.component;


import javax.inject.Singleton;

import dagger.Component;
import jobapp.sqli.com.jobapp.dagger.module.NetModule;
import jobapp.sqli.com.jobapp.models.DataSource;

@Singleton
@Component(modules={NetModule.class})
public interface NetComponent {
    void inject(DataSource dataSource);
}
