package by.it_academy.jd2.core.dto;


import org.junit.jupiter.api.*;

@DisplayName("Класс Person, предназначенный для создания человека")
public class PersonTest {
    private  Person person1;
    private  Person person2;
    private  Person person3;

    @BeforeEach
    public void setUpEach() throws Exception {
        person1 = new Person("Максимов", "Алкександр", "35");
        person2 = new Person("PETROVICH", "MIHAIL", "34");
        person3 = new Person("Гайдукова", "Анна", "7");
    }
    @AfterEach
    public void tearDownEach() throws Exception {
         Person person1 = null;
         Person person2 = null;
         Person person3 = null;
    }

    @DisplayName("Тест получения фамилии пользователя")
    @Test
    void getLastname() {
        String inspected1 =  person1.getLastname();
        String actual1 = "Максимов";
        Assertions.assertEquals(inspected1,actual1);

        String inspected2 =  person2.getLastname();
        String actual2 = "PETROVICH";
        Assertions.assertEquals(inspected2,actual2);

        String inspected3 =  person3.getLastname();
        String actual3 = "Гайдукова";
        Assertions.assertEquals(inspected3,actual3);


    }

    @DisplayName("Тест для изменения фамилии пользователя")
    @Test
    void setLastname() {
        String actual1 = "Максимов";
        person1.setLastname(actual1);
        Assertions.assertEquals(person1.getLastname(),actual1);

        String actual2 = "PETROVICH";
        person2.setLastname(actual2);
        Assertions.assertEquals(person2.getLastname(),actual2);

        String actual3 = "Гайдукова";
        person2.setLastname(actual3);
        Assertions.assertEquals(person3.getLastname(),actual3);
    }

    @DisplayName("Тест получения имени пользователя")
    @Test
    void getFirstname() {
        String inspected1 =  person1.getFirstname();
        String actual1 = "Алкександр";
        Assertions.assertEquals(inspected1,actual1);

        String inspected2 =  person2.getFirstname();
        String actual2 = "MIHAIL";
        Assertions.assertEquals(inspected2,actual2);

        String inspected3 =  person3.getFirstname();
        String actual3 = "Анна";
        Assertions.assertEquals(inspected3,actual3);
    }

    @DisplayName("Тест для изменения имени пользователя")
    @Test
    public void setFirstname() {
        String actual1 = "Алкександр";
        person1.setFirstname(actual1);
        Assertions.assertEquals(person1.getFirstname(),actual1);

        String actual2 = "MIHAIL";
        person2.setFirstname(actual2);
        Assertions.assertEquals(person2.getFirstname(),actual2);

        String actual3 = "Анна";
        person2.setFirstname(actual3);
        Assertions.assertEquals(person3.getFirstname(),actual3);
    }
    @DisplayName("Тест получения возраста пользователя")
    @Test
    public void getAge() {
        String inspected1 =  String.valueOf(person1.getAge()) ;
        String actual1 = "35";
        Assertions.assertEquals(inspected1,actual1);

        String inspected2 =  String.valueOf(person2.getAge());
        String actual2 = "34";
        Assertions.assertEquals(inspected2,actual2);

        String inspected3 =  String.valueOf(person3.getAge());
        String actual3 = "7";
        Assertions.assertEquals(inspected3,actual3);
    }

    @DisplayName("Тест для изменения даты пользователя")
    @Test
    public void setAge() {
        String actual1 = "35";
        person1.setAge(actual1);
        Assertions.assertEquals(String.valueOf(person1.getAge()),actual1);

        String actual2 = "34";
        person2.setAge(actual2);
        Assertions.assertEquals(String.valueOf(person2.getAge()),actual2);

        String actual3 = "7";
        person2.setAge(actual3);
        Assertions.assertEquals(String.valueOf(person3.getAge()),actual3);
    }
}