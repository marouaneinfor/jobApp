package jobapp.sqli.com.jobapp.pojo;


import org.parceler.Parcel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;

@Parcel
public class Candidat  extends RealmObject implements Comparable<Candidat> {
  private String picture;

  private String id;


  private String lastName;

  private String postedDate;

  private String currentRecommendation;

  private String age;

  private String job;

  private String experience;

  private String firstName;

  public Candidat() {
  }

  public Candidat(String picture, String id, String lastName, String postedDate, String age, String currentRecommendation, String job, String experience, String firstName) {
    this.picture = picture;
    this.id = id;
    this.lastName = lastName;
    this.postedDate = postedDate;
    this.age = age;
    this.currentRecommendation = currentRecommendation;
    this.job = job;
    this.experience = experience;
    this.firstName = firstName;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }



  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(String postedDate) {
    this.postedDate = postedDate;
  }

  public String getCurrentRecommendation() {
    return currentRecommendation;
  }

  public void setCurrentRecommendation(String currentRecommendation) {
    this.currentRecommendation = currentRecommendation;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String toString() {
    return "Candidat [picture = " + picture + ", id = " + id + ", lastName = " + lastName + ", postedDate = " + postedDate + ", currentRecommendation = " + currentRecommendation + ", age = " + age + ", job = " + job + ", experience = " + experience + ", firstName = " + firstName + "]";
  }
  public void copy(Candidat candidat) {
    this.picture = candidat.getPicture();
    this.id = candidat.getId();
    this.lastName = candidat.getLastName();
    this.postedDate = candidat.getPostedDate();
    this.age = candidat.getAge();
    this.currentRecommendation = candidat.getCurrentRecommendation();
    this.job = candidat.getJob();
    this.experience = candidat.getExperience();
    this.firstName = candidat.getFirstName();
  }
  @Override
  public int compareTo(Candidat o) {
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