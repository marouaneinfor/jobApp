package jobapp.sqli.com.jobapp.views.viewHolders;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jobapp.sqli.com.jobapp.BuildConfig;
import jobapp.sqli.com.jobapp.JobApp;
import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.helpers.ImageLoader;
import jobapp.sqli.com.jobapp.pojo.Candidat;

public class ViewHolderCandidat extends RecyclerView.ViewHolder {

    ImageView mImageView_candidat;
    TextView mTextView_name;
    TextView mTextView_job;
    TextView mTextView_age;
    TextView mTextView_recomandation;
    TextView mTextView_experience;
    TextView mTextView_contact;
    private View mView;

    public ViewHolderCandidat(View view) {
        super(view);
        this.mView = view;
        mTextView_name = (TextView) this.mView.findViewById(R.id.TextView_name);
        mTextView_job = (TextView) this.mView.findViewById(R.id.TextView_job);
        mTextView_age = (TextView) this.mView.findViewById(R.id.TextView_age);
        mTextView_recomandation = (TextView) this.mView.findViewById(R.id.TextView_recomandation);
        mTextView_experience = (TextView) this.mView.findViewById(R.id.TextView_experience);
        mImageView_candidat = (ImageView) this.mView.findViewById(R.id.imageView_candidat);
        mTextView_contact = (TextView) this.mView.findViewById(R.id.TextView_contact);
        if (!BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_ADMIN)) {
            mTextView_contact.setVisibility(View.GONE);
        }
    }

    public void setContent(Candidat candidat) {
        ImageLoader.loadImage(candidat.getmPicture(), mImageView_candidat);
        mTextView_name.setText(candidat.getmFirstName() + " " + candidat.getmLastName());
        mTextView_job.setText(candidat.getmJob());
        mTextView_age.setText(candidat.getmAge());
        mTextView_experience.setText(mView.getResources().getString(R.string.experience, candidat.getmExperience()));
        mTextView_recomandation.setText(mView.getResources().getString(R.string.experience, candidat.getmCurrentRecommendation())
        );
    }

    public TextView getTextView_recomandation() {
        return mTextView_recomandation;
    }

    public void setRecomandationCount(String recomandationCount, TextView mTextView_recomandation) {
        int recomandCount = Integer.parseInt(recomandationCount) + 1;
        mTextView_recomandation.setText(mView.getResources().getString(R.string.experience, String.valueOf(recomandCount)));
        mTextView_recomandation.setTextColor(ContextCompat.getColor(JobApp.getContext(), R.color.pink));
    }

}
