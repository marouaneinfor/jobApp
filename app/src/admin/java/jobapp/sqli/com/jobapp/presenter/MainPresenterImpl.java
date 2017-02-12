package jobapp.sqli.com.jobapp.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.dagger.interactors.DaggerInteractorComponent;
import jobapp.sqli.com.jobapp.dagger.interactors.InteractorModule;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;
import jobapp.sqli.com.jobapp.views.MainView;

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {
  @Inject FindItemsInteractor mFindItemsInteractor;
  private MainView mainView;
  private boolean isFinished ;
  private List<Object> mJobsAndCandidats = new ArrayList<>();

  public MainPresenterImpl(MainView mainView) {
    this.mainView = mainView;
    DaggerInteractorComponent.builder().interactorModule(new InteractorModule()).build().inject(this);
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
