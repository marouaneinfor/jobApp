package jobapp.sqli.com.jobapp.views.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.helpers.ImageLoader;
import jobapp.sqli.com.jobapp.pojo.Job;

public class ViewHolderRecruter extends RecyclerView.ViewHolder {

    ImageView mJob;
    TextView mTitle;
    TextView mPostedBy;
    TextView mPostedDate;
    TextView mViewedCount;
    TextView mSubmittedCount;

    private View mView;

    public ViewHolderRecruter(View view) {
        super(view);
        this.mView = view;
        mTitle = (TextView) this.mView.findViewById(R.id.title);
        mPostedBy = (TextView) this.mView.findViewById(R.id.postedBy);
        mPostedDate = (TextView) this.mView.findViewById(R.id.postedDate);
        mViewedCount = (TextView) this.mView.findViewById(R.id.viewedCount);
        mSubmittedCount = (TextView) this.mView.findViewById(R.id.submittedCount);
        mJob = (ImageView) this.mView.findViewById(R.id.picture);

    }

    public void setContent(Job job) {
        ImageLoader.loadImage(job.getmPicture(), mJob);
        mTitle.setText(job.getmTitle());
        mPostedBy.setText(mView.getResources().getString(R.string.postedBy, job.getmPostedBy()));
        mPostedDate.setText(mView.getResources().getString(R.string.postedBy, job.getmPostedDate()));
        mViewedCount.setText(job.getmViewedCount());
        mSubmittedCount.setText(job.getmSubmittedCount());

    }

}