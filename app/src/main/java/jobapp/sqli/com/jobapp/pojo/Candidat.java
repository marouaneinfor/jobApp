package jobapp.sqli.com.jobapp.pojo;


import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;

@Parcel
public class Candidat extends RealmObject implements Comparable<Candidat> {
    @SerializedName("picture")
    private String mPicture;

    @SerializedName("id")
    private String mId;

    @SerializedName("lastName")
    private String mLastName;

    @SerializedName("postedDate")
    private String mPostedDate;

    @SerializedName("currentRecommendation")
    private String mCurrentRecommendation;

    @SerializedName("age")
    private String mAge;

    @SerializedName("job")
    private String mJob;

    @SerializedName("experience")
    private String mExperience;

    @SerializedName("firstName")
    private String mFirstName;

    public Candidat() {
    }

    public Candidat(String picture, String id, String lastName, String postedDate, String age, String currentRecommendation, String job, String experience, String firstName) {
        this.mPicture = picture;
        this.mId = id;
        this.mLastName = lastName;
        this.mPostedDate = postedDate;
        this.mAge = age;
        this.mCurrentRecommendation = currentRecommendation;
        this.mJob = job;
        this.mExperience = experience;
        this.mFirstName = firstName;
    }

    public String getmPicture() {
        return mPicture;
    }

    public void setmPicture(String mPicture) {
        this.mPicture = mPicture;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }


    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmPostedDate() {
        return mPostedDate;
    }

    public void setmPostedDate(String mPostedDate) {
        this.mPostedDate = mPostedDate;
    }

    public String getmCurrentRecommendation() {
        return mCurrentRecommendation;
    }

    public void setmCurrentRecommendation(String mCurrentRecommendation) {
        this.mCurrentRecommendation = mCurrentRecommendation;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmJob() {
        return mJob;
    }

    public void setmJob(String mJob) {
        this.mJob = mJob;
    }

    public String getmExperience() {
        return mExperience;
    }

    public void setmExperience(String mExperience) {
        this.mExperience = mExperience;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    @Override
    public String toString() {
        return "Candidat [mPicture = " + mPicture + ", mId = " + mId + ", mLastName = " + mLastName + ", mPostedDate = " + mPostedDate + ", mCurrentRecommendation = " + mCurrentRecommendation + ", mAge = " + mAge + ", mJob = " + mJob + ", mExperience = " + mExperience + ", mFirstName = " + mFirstName + "]";
    }



    @Override
    public int compareTo(Candidat o) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Date postedDate = df.parse(this.mPostedDate);
            Date oPostedDate = df.parse(o.getmPostedDate());
            return postedDate.compareTo(oPostedDate);
        } catch (ParseException e) {
            //TODO
            e.printStackTrace();
        }
        return 0;
    }
}