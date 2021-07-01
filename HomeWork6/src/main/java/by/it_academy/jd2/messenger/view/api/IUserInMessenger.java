//package by.it_academy.jd2.messenger.view.api;
//
//import by.it_academy.jd2.messenger.model.Message;
//import by.it_academy.jd2.messenger.model.User;
//import java.util.HashMap;
//import java.util.List;
//
///**
// *  Интерфейс предназначенный для корректной работы приложения messenger.
// *  Классы, реализующие данный интерфейс, смогут: регистрировать и получать зарегестрированных пользователей,
// *  отправлять и получать сообщения
// */
//public interface IUserInMessenger {
//    /** Получить пользователя */
//    User getUser(String login);
//    /** Сохранить пользователя */
//    void saveUser(String login, User user);
//    /** Получить сообщения */
//    List<Message> getMessage(String login);
//    /** Сохранить сообщения */
//    void setMessage(String login, Message message);
////    /** Получить всех пользователей */
////    HashMap<String, User> getUsersInMessenger();
//
//}
