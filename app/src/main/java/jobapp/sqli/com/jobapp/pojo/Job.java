package jobapp.sqli.com.jobapp.pojo;

import org.parceler.Parcel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;

@Parcel
public class Job extends RealmObject implements Comparable<Job> {
  private String picture;

  private String title;

  private String postedDate;

  private String viewedCount;

  private String postedBy;

  private String submittedCount;

  public Job() {
  }

  public Job(String picture, String title, String postedDate, String viewedCount, String postedBy, String submittedCount) {
    this.picture = picture;
    this.title = title;
    this.postedDate = postedDate;
    this.viewedCount = viewedCount;
    this.postedBy = postedBy;
    this.submittedCount = submittedCount;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(String postedDate) {
    this.postedDate = postedDate;
  }

  public String getViewedCount() {
    return viewedCount;
  }

  public void setViewedCount(String viewedCount) {
    this.viewedCount = viewedCount;
  }

  public String getPostedBy() {
    return postedBy;
  }

  public void setPostedBy(String postedBy) {
    this.postedBy = postedBy;
  }

  public String getSubmittedCount() {
    return submittedCount;
  }

  public void setSubmittedCount(String submittedCount) {
    this.submittedCount = submittedCount;
  }

  public void copy(Job job) {
    this.picture = job.getPicture();
    this.title = job.getTitle();
    this.postedDate = job.getPostedDate();
    this.viewedCount = job.getViewedCount();
    this.postedBy = job.getPostedBy();
    this.submittedCount = job.getSubmittedCount();
  }

  @Override
  public String toString() {
    return "ClassPojo [picture = " + picture + ", title = " + title + ", postedDate = " + postedDate + ", viewedCount = " + viewedCount + ", postedBy = " + postedBy + ", submittedCount = " + submittedCount + "]";
  }


  @Override
  public int compareTo(Job o) {
    try {
      DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
      Date postedDate = df.parse(this.postedDate);
      Date oPostedDate = df.parse(o.getPostedDate());

      return postedDate.compareTo(oPostedDate);
    } catch (ParseException e) {
      //TODO
      e.printStackTrace();
    }
    return 0;
  }
}