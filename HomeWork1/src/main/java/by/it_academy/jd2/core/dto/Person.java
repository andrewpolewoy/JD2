package by.it_academy.jd2.core.dto;

public class Person {

    private String lastname;
    private String firstname;
    private int age;


    public Person(String lastname, String firstname, String age){
        this.lastname = lastname;
        this.firstname = firstname;
        if (age == null){
            this.age = 0;
        }else {
            this.age = Integer.parseInt(age);
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        if (age == null){
            this.age = 0;
        }else {
            this.age = Integer.parseInt(age);
        }

    }

}
