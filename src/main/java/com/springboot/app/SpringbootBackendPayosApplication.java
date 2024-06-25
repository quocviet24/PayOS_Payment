package com.springboot.app;
import com.lib.payos.PayOS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Configuration
public class SpringbootBackendPayosApplication implements WebMvcConfigurer {

	private String clientId = "6567e942-15db-48f9-9291-e02c5e46ff5a";

	private String apiKey = "6d502cdc-3944-4d0e-894c-d6cc1401c838";

	private String checksumKey = "aaf6543f7452540f08f226b89d6383dad7f3b1fef680cefb32fb953f0dbc741d";
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*")
				.exposedHeaders("*")
				.allowCredentials(false)
				.maxAge(3600); // Max age of the CORS pre-flight request
	}
	@Bean
	public PayOS payOS() {
		return new PayOS(clientId, apiKey, checksumKey);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendPayosApplication.class, args);
	}
}
