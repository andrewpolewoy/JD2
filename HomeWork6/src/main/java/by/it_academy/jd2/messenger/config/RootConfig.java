package by.it_academy.jd2.messenger.config;

import by.it_academy.jd2.messenger.storage.IMessageRepository;
import by.it_academy.jd2.messenger.storage.IUserRepository;
import by.it_academy.jd2.messenger.view.AuthService;
import by.it_academy.jd2.messenger.view.MessageService;
import by.it_academy.jd2.messenger.view.UserService;
import by.it_academy.jd2.messenger.view.api.IAuthService;
import by.it_academy.jd2.messenger.view.api.IMessageService;
import by.it_academy.jd2.messenger.view.api.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Определение конфигурации для компонентов пользователя
 */
@Configuration
@ComponentScan("by.it_academy.jd2.messenger.config")
public class RootConfig {

    /**
     * Конфигурация для интерфейса IMessageService
     *
     * @param repository Экземпляр репозитория IMessageRepository
     * @return объект, реализующий интерфейс IMessageService
     */
    @Bean
    public IMessageService getMessageService(IMessageRepository repository) {
        return new MessageService(repository);
    }

    /**
     * Конфигурация для интерфейса IUserService
     *
     * @param repository Экземпляр репозитория IUserRepository
     * @return объект, реализующий интерфейс IUserService
     */
    @Bean
    public IUserService getUserService(IUserRepository repository) {
        return new UserService(repository);
    }

    /**
     * Конфигурация для интерфейса IAuthService
     *
     * @param userService Экземпляр интерфейса IUserService
     * @return объект, реализующий интерфейс IAuthServicee
     */
    @Bean
    public IAuthService getAuthService(IUserService userService) {
        return new AuthService(userService);
    }
}
