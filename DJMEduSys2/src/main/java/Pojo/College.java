package Pojo;



public class College {

  private long id;
  private String collegeName;

  public College() {
  }

  public College(long id, String collegeName) {
    this.id = id;
    this.collegeName = collegeName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCollegeName() {
    return collegeName;
  }

  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

  @Override
  public String toString() {
    return "College{" +
            "id=" + id +
            ", collegeName='" + collegeName + '\'' +
            '}';
  }
}
