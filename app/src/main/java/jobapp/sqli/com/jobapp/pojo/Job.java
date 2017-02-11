package jobapp.sqli.com.jobapp.pojo;

import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;

@Parcel
public class Job extends RealmObject implements Comparable<Job> {
    @SerializedName("picture")
    private String mPicture;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("postedDate")
    private String mPostedDate;

    @SerializedName("viewedCount")
    private String mViewedCount;

    @SerializedName("postedBy")
    private String mPostedBy;

    @SerializedName("submittedCount")
    private String mSubmittedCount;

    public Job() {
    }

    public Job(String picture, String title, String postedDate, String viewedCount, String postedBy, String submittedCount) {
        this.mPicture = picture;
        this.mTitle = title;
        this.mPostedDate = postedDate;
        this.mViewedCount = viewedCount;
        this.mPostedBy = postedBy;
        this.mSubmittedCount = submittedCount;
    }

    public String getmPicture() {
        return mPicture;
    }

    public void setmPicture(String mPicture) {
        this.mPicture = mPicture;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPostedDate() {
        return mPostedDate;
    }

    public void setmPostedDate(String mPostedDate) {
        this.mPostedDate = mPostedDate;
    }

    public String getmViewedCount() {
        return mViewedCount;
    }

    public void setmViewedCount(String mViewedCount) {
        this.mViewedCount = mViewedCount;
    }

    public String getmPostedBy() {
        return mPostedBy;
    }

    public void setmPostedBy(String mPostedBy) {
        this.mPostedBy = mPostedBy;
    }

    public String getmSubmittedCount() {
        return mSubmittedCount;
    }

    public void setmSubmittedCount(String mSubmittedCount) {
        this.mSubmittedCount = mSubmittedCount;
    }

    public void copy(Job job) {
        this.mPicture = job.getmPicture();
        this.mTitle = job.getmTitle();
        this.mPostedDate = job.getmPostedDate();
        this.mViewedCount = job.getmViewedCount();
        this.mPostedBy = job.getmPostedBy();
        this.mSubmittedCount = job.getmSubmittedCount();
    }

    @Override
    public String toString() {
        return "ClassPojo [mPicture = " + mPicture + ", mTitle = " + mTitle + ", mPostedDate = " + mPostedDate + ", mViewedCount = " + mViewedCount + ", mPostedBy = " + mPostedBy + ", mSubmittedCount = " + mSubmittedCount + "]";
    }


    @Override
    public int compareTo(Job o) {
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