

package jobapp.sqli.com.jobapp.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jobapp.sqli.com.jobapp.BuildConfig;
import jobapp.sqli.com.jobapp.MainView;
import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.models.FindItemsInteractor;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {

  private MainView mainView;
  private FindItemsInteractor mFindItemsInteractor;
  private boolean isFinished = false;
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
    if (BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_RECRUTER)) {
      mFindItemsInteractor.requestJobs();

    } else if (BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_CANDIDAT)) {
      mFindItemsInteractor.requestCandidats();
    } else {
      mFindItemsInteractor.requestCandidatsAndJobs();

    }
  }


  public MainView getMainView() {
    return mainView;
  }

  @Override
  public void onJobsLoaded(List<Job> jobs) {
    if (!BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_ADMIN)) {
      List<Object> mjobs = new ArrayList<Object>(jobs);
      if (mainView != null) {
        mainView.setItems(mjobs);
        mainView.hideProgress();
      }
    } else {
      onCandidatsAndJobsLoaded(new ArrayList<Object>(jobs));
    }

  }

  @Override
  public void onJobsLoadFailed() {
    if (!BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_ADMIN)) {
      if (mainView != null) {
        mainView.hideProgress();

        mainView.setError(JobConstants.ERROR_MESSAGE);
      }
    } else {
      onCandidatsAndJobsFailed();
    }
  }

  @Override
  public void onCandidatsLoaded(List<Candidat> candidats) {
    if (!BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_ADMIN)) {
      {
        Collections.sort(candidats);
        List<Object> mCandidats = new ArrayList<Object>(candidats);
        if (mainView != null) {
          mainView.setItems(mCandidats);
          mainView.hideProgress();
        }
      }
    } else {
      onCandidatsAndJobsLoaded(new ArrayList<Object>(candidats));

    }

  }

  @Override
  public void onCandidatsFailed() {
    if (!BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_ADMIN)) {
      if (mainView != null) {
        mainView.hideProgress();

        mainView.setError(JobConstants.ERROR_MESSAGE);
      }
    } else {
      onCandidatsAndJobsFailed();
    }
  }

  @Override
  public void onCandidatsAndJobsLoaded(List<Object> JobsAndCandidats) {
    mJobsAndCandidats.addAll(JobsAndCandidats);
    if (mainView != null && isFinished) {
      mainView.setItems(mJobsAndCandidats);
      mainView.hideProgress();
    }
    isFinished = true;
  }

  @Override
  public void onCandidatsAndJobsFailed() {
    if (mainView != null) {
      mainView.hideProgress();
      mainView.setError(JobConstants.ERROR_MESSAGE);
    }
  }
}
