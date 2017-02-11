package jobapp.sqli.com.jobapp.presenter;

import java.util.ArrayList;
import java.util.List;

import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;
import jobapp.sqli.com.jobapp.views.MainView;

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {

  private MainView mainView;
  private FindItemsInteractor mFindItemsInteractor;
  private boolean isFinished ;
  private List<Object> mJobsAndCandidats = new ArrayList<>();

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
    mJobsAndCandidats.addAll(data);
    if (mainView != null && isFinished) {
      mainView.setItems(mJobsAndCandidats);
      mainView.hideProgress();
    }
    isFinished = true;
  }

  @Override
  public void onDataFailed() {
    if (mainView != null) {
      mainView.hideProgress();
      mainView.setError(JobConstants.ERROR_MESSAGE);
    }
  }
}
