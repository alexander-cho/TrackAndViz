package dev.vf.ch11openfeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "dev.vf.ch11openfeign.proxy")
public class ProjectConfig {
}
