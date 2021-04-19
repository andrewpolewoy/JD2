package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserInMessengerTest {

    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;
    private final UserInMessenger userInMessenger = new UserInMessenger();
    public static HashMap<String, User> usersInMessenger = new HashMap<>();
    private Message message1;
    private Message message2;

    @BeforeEach
    public void setUpEach() throws Exception {
        user1 = new User("Максимов", "LAMA", "3558", "12.12.59");
        user2 = new User("PETROVICH", "12кило", "34kilo", "11.11.87");
        user3 = new User("Гайдукова", "LAMAch", "hhYu", "25.04.96");
        user4 = new User("Gtthg", "887", "lomtic", "12.04.91");
        user5 = new User("rerwef", "Uber", "4matic", "12.06.91");
        message1 = new Message();
        message1.setText("Какой-то текст");
        message1.setFrom(user1.getLogin());
        message1.setSendDate(new Date());

        message2 = new Message();
        message2.setText("Ещё один Какой-то текст");
        message2.setFrom(user2.getLogin());
        message2.setSendDate(new Date());
    }

    @AfterEach
    public void tearDownEach() throws Exception {
        user1 = null;
        user2 = null;
        user3 = null;
        user4 = null;
        user5 = null;
        usersInMessenger = null;
        message1 = null;
        message2 = null;
    }

    @DisplayName("Тест получения пользователей")
    @Test
    void getUsersInMessenger() {
        int size = userInMessenger.getUsersInMessenger().size();
        userInMessenger.saveUser("LAMAch", user3);
        userInMessenger.saveUser("887", user4);
        HashMap<String, User> usersInMessenger = userInMessenger.getUsersInMessenger();
        int inspectedSize = usersInMessenger.size();
        String inspectedLogin = usersInMessenger.get("LAMAch").getLogin();
        String actualLogin = "LAMAch";
        String inspectedLogin1 = usersInMessenger.get("887").getLogin();
        String actualLogin1 = "887";
        Assertions.assertEquals(2, (inspectedSize - size));
        Assertions.assertEquals(inspectedLogin, actualLogin);
        Assertions.assertEquals(inspectedLogin1, actualLogin1);
    }

    @DisplayName("Тест сохранения пользователя")
    @Test
    public void saveUser() {
        userInMessenger.saveUser("LAMA", user1);
        userInMessenger.saveUser("12кило", user2);

        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            userInMessenger.saveUser("LAMA", user3);
        });
        String inspected = userInMessenger.getUser(user1.getLogin()).getLogin();
        String actual = user1.getLogin();
        Assertions.assertEquals(inspected, actual);
        assertNotNull(thrown.getMessage());

    }

    @DisplayName("Тест получения пользователя")
    @Test
    void getUser() {
        userInMessenger.saveUser("Uber", user5);
        String inspected = userInMessenger.getUser(user5.getLogin()).getLogin();
        String actual = user5.getLogin();
        Assertions.assertEquals(actual, inspected);
    }

    @DisplayName("Тест получения сообщений пользователя")
    @Test
    void getMessage() {
        ArrayList<Message> mess = new ArrayList<>();
        userInMessenger.setMessage(user3.getLogin(), message1);
        userInMessenger.setMessage(user3.getLogin(), message2);
        mess.add(message1);
        mess.add(message2);
        ArrayList<Message> message = userInMessenger.getMessage(user3.getLogin());
        Assertions.assertEquals(mess.get(0), message.get(0));
        Assertions.assertEquals(mess.get(1), message.get(1));
    }

    @DisplayName("Тест сохранения сообщений пользователя")
    @Test
    void setMessage() {
        ArrayList<Message> mess1 = new ArrayList<>();
        userInMessenger.setMessage(user4.getLogin(), message1);
        userInMessenger.setMessage(user4.getLogin(), message2);
        mess1.add(message1);
        mess1.add(message2);
        ArrayList<Message> message1 = userInMessenger.getMessage(user4.getLogin());
        Assertions.assertEquals(mess1.get(0), message1.get(0));
        Assertions.assertEquals(mess1.get(1), message1.get(1));
    }

    @DisplayName("Тест получения экземпляра собственного класса")
    @Test
    void getInstance() {
        UserInMessenger instance = UserInMessenger.getInstance();
        Assertions.assertEquals(instance, instance);
    }
}