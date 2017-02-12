package jobapp.sqli.com.jobapp.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.pojo.Candidat;
import jobapp.sqli.com.jobapp.pojo.Job;
import jobapp.sqli.com.jobapp.views.viewHolders.ViewHolderCandidat;
import jobapp.sqli.com.jobapp.views.viewHolders.ViewHolderRecruter;

public class MultipleViewTypesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


  private List<Object> mList;

  public MultipleViewTypesAdapter(List<Object> list) {
    this.mList = list;
  }

  @Override
  public int getItemViewType(int position) {
    if (mList.get(position) instanceof Job) {
      return JobConstants.VIEW_TYPE_FOR_RECRUTER;
    } else {
      return JobConstants.VIEW_TYPE_FOR_CANDIDAT;
    }

  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    switch (viewType) {
      case JobConstants.VIEW_TYPE_FOR_CANDIDAT:
        View itemViewCandidat = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.candidat_item, parent, false);
        return new ViewHolderCandidat(itemViewCandidat);
      case JobConstants.VIEW_TYPE_FOR_RECRUTER:
        View itemViewRecruter = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.job_item, parent, false);
        return new ViewHolderRecruter(itemViewRecruter);
      default:
        return null;
    }
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, final  int position) {

    switch (getItemViewType(position)) {
      case JobConstants.VIEW_TYPE_FOR_CANDIDAT:
        final Candidat candidat=(Candidat)mList.get(position);
       final ViewHolderCandidat mViewHolderCandidat = (ViewHolderCandidat) holder;
        mViewHolderCandidat.setContent((Candidat) mList.get(position));
        mViewHolderCandidat.getmRecomandation().setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            mViewHolderCandidat.setRecomandationCount(candidat.getmCurrentRecommendation(),mViewHolderCandidat.getmRecomandation());
          }
        });
        break;
      case JobConstants.VIEW_TYPE_FOR_RECRUTER:
        ViewHolderRecruter mViewHolderRecruter = (ViewHolderRecruter) holder;
        mViewHolderRecruter.setContent((Job) mList.get(position));

        break;
    }
  }

  @Override
  public int getItemCount() {
    return mList.size();
  }
}