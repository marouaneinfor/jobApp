

package jobapp.sqli.com.jobapp.models;

import java.util.List;

import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;

public interface FindItemsInteractor {

  interface OnFinishedListener {
    void onJobsLoaded(List<Job> jobs);

    void onJobsLoadFailed();

    void onCandidatsLoaded(List<Candidat> candidats);

    void onCandidatsFailed();

    void onCandidatsAndJobsLoaded(List<Object> JobsAndCandidats);

    void onCandidatsAndJobsFailed();

  }

  void requestCandidats();

  void requestCandidatsAndJobs();

  void requestJobs();

  void addListener(FindItemsInteractor.OnFinishedListener listener);

  void removeListener(FindItemsInteractor.OnFinishedListener listener);
}
