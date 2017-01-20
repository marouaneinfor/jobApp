package jobapp.sqli.com.jobapp.model;




public class Job
{
  private String picture;

  private String id;

  private String[] tags;

  private String lastName;

  private String postedDate;

  private String currentRecommendation;

  private String age;

  private String job;

  private String experience;

  private String firstName;

  public Job() {
  }

  public Job(String picture, String id, String[] tags, String lastName, String postedDate, String currentRecommendation, String age, String job, String experience, String firstName) {
    this.picture = picture;
    this.id = id;
    this.tags = tags;
    this.lastName = lastName;
    this.postedDate = postedDate;
    this.currentRecommendation = currentRecommendation;
    this.age = age;
    this.job = job;
    this.experience = experience;
    this.firstName = firstName;
  }

  public String getPicture ()
  {
    return picture;
  }

  public void setPicture (String picture)
  {
    this.picture = picture;
  }

  public String getId ()
  {
    return id;
  }

  public void setId (String id)
  {
    this.id = id;
  }

  public String[] getTags ()
  {
    return tags;
  }

  public void setTags (String[] tags)
  {
    this.tags = tags;
  }

  public String getLastName ()
  {
    return lastName;
  }

  public void setLastName (String lastName)
  {
    this.lastName = lastName;
  }

  public String getPostedDate ()
  {
    return postedDate;
  }

  public void setPostedDate (String postedDate)
  {
    this.postedDate = postedDate;
  }

  public String getCurrentRecommendation ()
  {
    return currentRecommendation;
  }

  public void setCurrentRecommendation (String currentRecommendation)
  {
    this.currentRecommendation = currentRecommendation;
  }

  public String getAge ()
  {
    return age;
  }

  public void setAge (String age)
  {
    this.age = age;
  }

  public String getJob ()
  {
    return job;
  }

  public void setJob (String job)
  {
    this.job = job;
  }

  public String getExperience ()
  {
    return experience;
  }

  public void setExperience (String experience)
  {
    this.experience = experience;
  }

  public String getFirstName ()
  {
    return firstName;
  }

  public void setFirstName (String firstName)
  {
    this.firstName = firstName;
  }

  @Override
  public String toString()
  {
    return "ClassPojo [picture = "+picture+", id = "+id+", tags = "+tags+", lastName = "+lastName+", postedDate = "+postedDate+", currentRecommendation = "+currentRecommendation+", age = "+age+", job = "+job+", experience = "+experience+", firstName = "+firstName+"]";
  }
}
