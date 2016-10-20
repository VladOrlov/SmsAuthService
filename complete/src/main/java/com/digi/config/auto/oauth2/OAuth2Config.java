package com.digi.config.auto.oauth2;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

*/

/**
 * Created by tymoshenkol on 20-Oct-16.
 */
public class OAuth2Config {}

/*
@Configuration
@EnableAuthorizationServer
public class OAuth2Config() extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure (AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

	@Override
	public void configure (ClientDetailsServiceConfigurer clients) throws Exception {
		// @formatter:off
		clients.inMemory()
				.withClient("my-other-client-with-secret")
				.authorizedGrantTypes("password")
				.authorities("ROLE_CLIENT")
				.scopes("read", "trust")
				.resourceIds("oauth2/other")
				.secret("secret");
		// @formatter:on
	}

}
*/
