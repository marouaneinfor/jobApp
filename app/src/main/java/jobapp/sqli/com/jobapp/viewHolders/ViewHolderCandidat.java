package jobapp.sqli.com.jobapp.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jobapp.sqli.com.jobapp.BuildConfig;
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
  private ImageLoader mImageLoader;

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
    mImageLoader = new ImageLoader(this.mView.getContext());
  }
  public void setContent(Candidat candidat) {
    mImageLoader.loadImage(candidat.getPicture(), mImageView_candidat);
    mTextView_name.setText(candidat.getFirstName() + " " + candidat.getLastName());
    mTextView_job.setText(candidat.getJob());
    mTextView_age.setText(candidat.getAge());
    mTextView_experience.setText("Ex: " + candidat.getExperience() + " an(s)");
    mTextView_recomandation.setText("RECOMANDER (" + candidat.getCurrentRecommendation() +
        ")");  }
  public TextView getTextView_recomandation() {
    return mTextView_recomandation;
  }
  public void setRecomandationCount(String recomandationCount,TextView mTextView_recomandation) {
    int recomandCount =Integer.parseInt(recomandationCount)+1;
    mTextView_recomandation.setText("RECOMANDER (" + recomandCount +
     ")");
    mTextView_recomandation.setTextColor(this.mView.getContext().getResources().getColor(R.color
        .pink));
  }

}
