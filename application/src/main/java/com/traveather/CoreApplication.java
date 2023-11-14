package com.traveather;

import com.traveather.common.entity.AuditableEntity;
import com.traveather.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Traveather Application",
                version = "1.0.0 - SNAPSHOT",
                contact = @Contact(name = "Sebastian Orlowski", email = "sebastian.orlowski@pm.me")
        )
)
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}