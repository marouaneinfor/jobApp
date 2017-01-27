package jobapp.sqli.com.jobapp.models;


import java.util.List;

import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FindItemsService {

  @GET("41OUsE5UW")
  Call<List<Job>> requestJobs();

  @GET("EJ5uiN98b")
  Call<List<Candidat>> requestCandidats();


}
