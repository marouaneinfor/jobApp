package jobapp.sqli.com.jobapp.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.model.Job;



public class JobAdapter extends RecyclerView.Adapter<JobAdapter.MyViewHolder> {

  private List<Job> mJobList;

  public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView title, year, genre;

    public MyViewHolder(View view) {
      super(view);
      //genre = (TextView) view.findViewById(R.id.cardview_list_Job_title);
      //year = (TextView) view.findViewById(R.id.short_description);
    }
  }


  public JobAdapter(List<Job> moviesList) {
    this.mJobList = moviesList;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.job_item, parent, false);

    return new MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    Job job = mJobList.get(position);
    //holder.genre.setText(job.getGenre());
    //holder.year.setText(job.getYear());
  }

  @Override
  public int getItemCount() {
    return mJobList.size();
  }
}