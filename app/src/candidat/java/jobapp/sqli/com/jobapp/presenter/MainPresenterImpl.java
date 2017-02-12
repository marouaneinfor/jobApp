

package jobapp.sqli.com.jobapp.presenter;

import java.util.List;

import javax.inject.Inject;

import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.dagger.DaggerLogicComponent;
import jobapp.sqli.com.jobapp.dagger.DaggerNetComponent;
import jobapp.sqli.com.jobapp.dagger.LogicModule;
import jobapp.sqli.com.jobapp.dagger.NetModule;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;
import jobapp.sqli.com.jobapp.views.MainView;

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {

  private MainView mainView;
  @Inject FindItemsInteractor mFindItemsInteractor;

  public MainPresenterImpl(MainView mainView) {
    this.mainView = mainView;
      DaggerLogicComponent.builder().interactorModule(new InteractorModule()).build().inject(this);
    this.mFindItemsInteractor.addListener(this);
  }

  @Override
  public void onDestroy() {
    mainView = null;
  }

  @Override
  public void onResume() {
    if (mainView != null) {
      mainView.showProgress();
    }
    mFindItemsInteractor.getItems();
  }

  @Override
  public MainView getMainView() {
    return mainView;
  }


  @Override
  public void onDataLoaded(List<Object> data) {
    if (mainView != null) {
      mainView.setItems(data);
      mainView.hideProgress();
    }
  }

  @Override
  public void onDataFailed() {
    if (mainView != null) {
      mainView.hideProgress();
      mainView.setError(JobConstants.ERROR_MESSAGE);
    }
  }
}
