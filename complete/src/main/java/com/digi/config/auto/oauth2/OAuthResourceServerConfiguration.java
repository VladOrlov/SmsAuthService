package com.digi.config.auto.oauth2;

/*
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
*/

/**
 * Created by tymoshenkol on 20-Oct-16.
 */
public class OAuthResourceServerConfiguration {}
/*
@Configuration
@EnableResourceServer
public class OAuthResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure (ResourceServerSecurityConfigurer resources) {
		resources.resourceId("oauth2/admin");
	}

	@Override
	public void configure (HttpSecurity http) throws Exception {
		http.anonymous().and()
				.authorizeRequests()
				.antMatchers(
						//Enable Swagger documentation
						"/swagger-ui.html", "/configuration/*", "/swagger-resources", "/v2/api-docs"
				).permitAll()
				.antMatchers(HttpMethod.GET, "/v1").access("#oauth2.hasScope('read')")
				.antMatchers(HttpMethod.POST, "/v1").access("#oauth2.hasScope('read')")
				.anyRequest().authenticated();
	}
}

*/