package jobapp.sqli.com.jobapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jobapp.sqli.com.jobapp.model.Job;
import jobapp.sqli.com.jobapp.presenter.JobAdapter;

public class MainActivity extends AppCompatActivity {
  private List<Job> jobList = new ArrayList<>();
  private RecyclerView recyclerView;
  private JobAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    mAdapter = new JobAdapter(jobList);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(mAdapter);

    prepareMovieData();

  }

  private void prepareMovieData() {
    Job job = new Job("Mad Max: Fury Road", "Action & Adventure", "2015");
    jobList.add(job);
    jobList.add(job);
    jobList.add(job);
    jobList.add(job);
    jobList.add(job);
    jobList.add(job);
    jobList.add(job);
    jobList.add(job);
    jobList.add(job);

    mAdapter.notifyDataSetChanged();
  }
}
