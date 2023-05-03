package Pojo;


public class Teacher {

  private long id;
  private String tCode;
  private String tName;
  private long age;
  private String graduate;
  private long salary;
  private long cId;

  public Teacher() {
  }

  public Teacher(long id, String tCode, String tName, long age, String graduate, long salary, long cId) {
    this.id = id;
    this.tCode = tCode;
    this.tName = tName;
    this.age = age;
    this.graduate = graduate;
    this.salary = salary;
    this.cId = cId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTCode() {
    return tCode;
  }

  public void setTCode(String tCode) {
    this.tCode = tCode;
  }


  public String getTName() {
    return tName;
  }

  public void setTName(String tName) {
    this.tName = tName;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getGraduate() {
    return graduate;
  }

  public void setGraduate(String graduate) {
    this.graduate = graduate;
  }


  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }


  public long getCId() {
    return cId;
  }

  public void setCId(long cId) {
    this.cId = cId;
  }

  @Override
  public String toString() {
    return "Teacher{" +
            "id=" + id +
            ", tCode='" + tCode + '\'' +
            ", tName='" + tName + '\'' +
            ", age=" + age +
            ", graduate='" + graduate + '\'' +
            ", salary=" + salary +
            ", cId=" + cId +
            '}';
  }
}
