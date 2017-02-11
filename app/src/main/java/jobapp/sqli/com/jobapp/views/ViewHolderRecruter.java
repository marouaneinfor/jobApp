package jobapp.sqli.com.jobapp.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.helpers.ImageLoader;
import jobapp.sqli.com.jobapp.pojo.Job;

public class ViewHolderRecruter extends RecyclerView.ViewHolder {

    ImageView mImageView_job;
    TextView mTextView_title;
    TextView mTextView_postedBy;
    TextView mTextView_postedDate;
    TextView mTextView_viewedCount;
    TextView mTextView_submittedCount;
    private ImageLoader mImageLoader;

    private View mView;

    public ViewHolderRecruter(View view) {
        super(view);
        this.mView = view;
        mTextView_title = (TextView) this.mView.findViewById(R.id.TextView_title);
        mTextView_postedBy = (TextView) this.mView.findViewById(R.id.TextView_postedBy);
        mTextView_postedDate = (TextView) this.mView.findViewById(R.id.TextView_postedDate);
        mTextView_viewedCount = (TextView) this.mView.findViewById(R.id.TextView_viewedCount);
        mTextView_submittedCount = (TextView) this.mView.findViewById(R.id.TextView_submittedCount);
        mImageView_job = (ImageView) this.mView.findViewById(R.id.imageView_job);
        mImageLoader = new ImageLoader(this.mView.getContext());

    }

    public void setContent(Job job) {
        mImageLoader.loadImage(job.getmPicture(), mImageView_job);
        mTextView_title.setText(job.getmTitle());
        mTextView_postedBy.setText(mView.getResources().getString(R.string.postedBy, job.getmPostedBy()));
        mTextView_postedDate.setText(mView.getResources().getString(R.string.postedBy, job.getmPostedDate()));
        mTextView_viewedCount.setText(job.getmViewedCount());
        mTextView_submittedCount.setText(job.getmSubmittedCount());

    }

}