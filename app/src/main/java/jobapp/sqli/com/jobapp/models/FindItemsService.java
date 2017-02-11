package jobapp.sqli.com.jobapp.models;


import java.util.List;

import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FindItemsService {

  @GET(JobConstants.JOBS_URL)
  Call<List<Job>> requestJobs();

  @GET(JobConstants.CANDIDATS_URL)
  Call<List<Candidat>> requestCandidats();


}
