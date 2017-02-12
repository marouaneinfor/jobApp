package jobapp.sqli.com.jobapp.models;


import java.util.List;

import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;
import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface FindItemsService {

  @GET(JobConstants.JOBS_URL)
  Observable<List<Job>> requestJobs();

  @GET(JobConstants.CANDIDATS_URL)
  Observable<List<Candidat>> requestCandidats();


}
