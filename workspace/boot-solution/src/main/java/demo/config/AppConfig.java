package demo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "data.properties")
public class AppConfig {

	@Bean
	@ConfigurationProperties("data")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
