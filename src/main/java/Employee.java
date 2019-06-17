public class Employee {

    private long birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private long hire_date;

    public Employee() {
    }

    public Employee(long birth_date, String first_name, String last_name, String gender, long hire_date) {
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
    }

    public long getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(long birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getHire_date() {
        return hire_date;
    }

    public void setHire_date(long hire_date) {
        this.hire_date = hire_date;
    }
}
