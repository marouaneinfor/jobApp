

package jobapp.sqli.com.jobapp.presenter;

import java.util.List;

import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;
import jobapp.sqli.com.jobapp.views.MainView;

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {

  private MainView mainView;
  private FindItemsInteractor mFindItemsInteractor; //TODO Dagger

  public MainPresenterImpl(MainView mainView, FindItemsInteractor findItemsInteractor) {
    this.mainView = mainView;
    this.mFindItemsInteractor = findItemsInteractor;
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
