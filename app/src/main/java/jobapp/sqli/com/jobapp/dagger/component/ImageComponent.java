package jobapp.sqli.com.jobapp.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import jobapp.sqli.com.jobapp.dagger.module.ImageHelperModule;
import jobapp.sqli.com.jobapp.views.viewHolders.ViewHolderCandidat;
import jobapp.sqli.com.jobapp.views.viewHolders.ViewHolderRecruter;


@Singleton
@Component(modules={ImageHelperModule.class})
public interface ImageComponent {
    void inject(ViewHolderRecruter viewHolderRecruter);
    void inject(ViewHolderCandidat viewHolderCandidat);

}
