package by.it_academy.jd2.core.dto;

/**
 * Класс Person, предназначенный для создания человека
 * с параметрами <b>lastname</b>, <b>firstname</b> и <b>age</b>
 */
public class Person {
    /** Поле имя */
    private String lastname;
    /** Поле фамилия */
    private String firstname;
    /** Поле возраст */
    private int age;

    /**
     *Конструктор - создание нового объекта с определенными значениями
     * @param lastname - имя
     * @param firstname - фамилия
     * @param age - возраст
     */
    public Person(String lastname, String firstname, String age){
        this.lastname = lastname;
        this.firstname = firstname;
        if (age == null){
            this.age = 0;
        }else {
            this.age = Integer.parseInt(age);
        }
    }
    /**
     * Метод получения значения поля {@link Person#lastname}
     * @return возвращает фамилию
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * Метод определения фамилии {@link Person#lastname}
     * @param lastname - фамилия
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * Метод получения значения поля {@link Person#firstname}
     * @return возвращает имя
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * Метод определения имени {@link Person#firstname}
     * @param firstname - имя
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * Метод получения значения поля {@link Person#age}
     * @return возвращает возраст
     */
    public int getAge() {
        return age;
    }
    /**
     * Метод определения возраста {@link Person#age}
     * @param age - возраст
     */
    public void setAge(String age) {
        if (age == null){
            this.age = 0;
        }else {
            this.age = Integer.parseInt(age);
        }

    }

}
