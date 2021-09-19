package uz.job.task.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "uz.job.task.repository")
public class DatabaseConfiguration {
}
