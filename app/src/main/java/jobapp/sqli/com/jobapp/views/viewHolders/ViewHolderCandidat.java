package jobapp.sqli.com.jobapp.views.viewHolders;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import jobapp.sqli.com.jobapp.BuildConfig;
import jobapp.sqli.com.jobapp.JobApp;
import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.constants.JobConstants;
import jobapp.sqli.com.jobapp.dagger.component.DaggerImageComponent;
import jobapp.sqli.com.jobapp.dagger.module.ImageHelperModule;
import jobapp.sqli.com.jobapp.helpers.ImageLoader;
import jobapp.sqli.com.jobapp.pojo.Candidat;

public class ViewHolderCandidat extends RecyclerView.ViewHolder {

    ImageView mPicture;
    TextView mName;
    TextView mJob;
    TextView mAge;
    TextView mRecomandation;
    TextView mExperience;
    TextView mContact;
    private View mView;
    @Inject
    ImageLoader mImageLoader;

    public ViewHolderCandidat(View view) {
        super(view);
        this.mView = view;
        mName = (TextView) this.mView.findViewById(R.id.name);
        mJob = (TextView) this.mView.findViewById(R.id.job);
        mAge = (TextView) this.mView.findViewById(R.id.age);
        mRecomandation = (TextView) this.mView.findViewById(R.id.recommandation);
        mExperience = (TextView) this.mView.findViewById(R.id.experience);
        mPicture = (ImageView) this.mView.findViewById(R.id.picture);
        mContact = (TextView) this.mView.findViewById(R.id.TextView_contact);
        if (!BuildConfig.USER_TYPE.equals(JobConstants.USER_TYPE_ADMIN)) {
            mContact.setVisibility(View.GONE);
        }
        DaggerImageComponent.builder().imageHelperModule(new ImageHelperModule(mPicture)).build().inject(this);

    }

    public void setContent(Candidat candidat) {
        mImageLoader.loadImage(candidat.getmPicture());
        mName.setText(candidat.getmFirstName() + " " + candidat.getmLastName());
        mJob.setText(candidat.getmJob());
        mAge.setText(candidat.getmAge());
        mExperience.setText(mView.getResources().getString(R.string.experience, candidat.getmExperience()));
        mRecomandation.setText(mView.getResources().getString(R.string.experience, candidat.getmCurrentRecommendation())
        );
    }

    public TextView getmRecomandation() {
        return mRecomandation;
    }

    public void setRecomandationCount(String recomandationCount, TextView mRecomandation) {
        int recomandCount = Integer.parseInt(recomandationCount) + 1;
        mRecomandation.setText(mView.getResources().getString(R.string.experience, String.valueOf(recomandCount)));
        mRecomandation.setTextColor(ContextCompat.getColor(JobApp.getContext(), R.color.pink));
    }

}
