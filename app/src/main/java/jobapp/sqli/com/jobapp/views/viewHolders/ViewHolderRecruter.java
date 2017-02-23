package jobapp.sqli.com.jobapp.views.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.dagger.component.DaggerImageComponent;
import jobapp.sqli.com.jobapp.dagger.module.ImageHelperModule;
import jobapp.sqli.com.jobapp.helpers.ImageLoader;
import jobapp.sqli.com.jobapp.pojo.Job;

public class ViewHolderRecruter extends RecyclerView.ViewHolder {

    ImageView mJob;
    TextView mTitle;
    TextView mPostedBy;
    TextView mPostedDate;
    TextView mViewedCount;
    TextView mSubmittedCount;
    @Inject
  ImageLoader mImageLoader;
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

        DaggerImageComponent.builder().imageHelperModule(new ImageHelperModule(mJob)).build().inject(this);

    }

    public void setContent(Job job) {
        mImageLoader.loadImage(job.getmPicture());
        mTitle.setText(job.getmTitle());
        mPostedBy.setText(mView.getResources().getString(R.string.postedBy, job.getmPostedBy()));
        mPostedDate.setText(mView.getResources().getString(R.string.postedBy, job.getmPostedDate()));
        mViewedCount.setText(job.getmViewedCount());
        mSubmittedCount.setText(job.getmSubmittedCount());

    }

}