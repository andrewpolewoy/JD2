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

/** Определение конфигурации для компонентов пользователя */
@Configuration
@ComponentScan("by.it_academy.jd2.messenger.config")
public class RootConfig {

    /**
     * Конфигурация для интерфейса {@link IMessageService}
     * @param repository Экземпляр репозитория {@link IMessageRepository}
     * @return объект, реализующий интерфейс {@link IMessageService}
     */
    @Bean
    public IMessageService getMessageService(IMessageRepository repository) {
        return new MessageService(repository);
    }

    /**
     * Конфигурация для интерфейса {@link IUserService}
     * @param repository Экземпляр репозитория {@link IUserRepository}
     * @return объект, реализующий интерфейс {@link IUserService}
     */
    @Bean
    public IUserService getUserService(IUserRepository repository) {
        return new UserService(repository);
    }

    /**
     * Конфигурация для интерфейса {@link IAuthService}
     * @param userService Экземпляр интерфейса {@link IUserService}
     * @return объект, реализующий интерфейс {@link IAuthService}
     */
    @Bean
    public IAuthService getAuthService(IUserService userService) {
        return new AuthService(userService);
    }
}
