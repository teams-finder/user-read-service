package com.teamsfinder.userreadservice.user;

import com.teamsfinder.userreadservice.UserReadServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;

@AutoConfigureMockMvc
@SpringBootTest(classes = UserReadServiceApplication.class)
public abstract class IntegrationBaseClass {

    private static final PostgreSQLContainer postgresContainer;
    private static final String SPRING_DB_URL_PROPERTY = "spring.datasource.url";
    private static final String SPRING_DB_PASSWORD_PROPERTY = "spring.datasource.password";
    private static final String SPRING_DB_USERNAME_PROPERTY = "spring.datasource.username";
    private static final String SPRING_DB_DRIVER_CLASS_NAME_PROPERTY = "spring.datasource.driverClassName";

    static {
        postgresContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:latest")
                .withReuse(true);
        postgresContainer.start();
    }

    @Autowired
    protected MockMvc mockMvc;

    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add(SPRING_DB_URL_PROPERTY, postgresContainer::getJdbcUrl);
        registry.add(SPRING_DB_PASSWORD_PROPERTY, postgresContainer::getPassword);
        registry.add(SPRING_DB_USERNAME_PROPERTY, postgresContainer::getUsername);
        registry.add(SPRING_DB_DRIVER_CLASS_NAME_PROPERTY, postgresContainer::getDriverClassName);
    }
}