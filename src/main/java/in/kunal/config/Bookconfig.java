package in.kunal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import in.kunal.binding.Book;
@Configuration
public class Bookconfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] unsupported  = {HttpMethod.PUT , HttpMethod.DELETE};
		config.getExposureConfiguration()
		.forDomainType(Book.class)
		.withItemExposure((metadata,http) -> http.disable(unsupported))
		.withCollectionExposure((metadata, http) -> http.disable(unsupported));
		
 		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
	} 

}
