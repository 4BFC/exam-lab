package capstone.examlab.user.config;

import capstone.examlab.user.domain.User;
import capstone.examlab.user.domain.UserDoc;
import capstone.examlab.user.domain.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserConfig {
    @Bean
    @Profile("jpa")
    @Scope("prototype")
    public User userJpa() {
        return new UserEntity();
    }

    @Bean
    @Profile("mongo")
    @Scope("prototype")
    public User userMongo() {
        return new UserDoc();
    }
}