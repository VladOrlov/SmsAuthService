package com.digi.config.auto;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Configuration
public class CorsFilterConfig {

	private static UrlBasedCorsConfigurationSource configurationSource () {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public FilterRegistrationBean corsFilter () {
		FilterRegistrationBean bean = new FilterRegistrationBean(new AppCorsFilter());
		bean.setOrder(0);
		return bean;
	}

	public class AppCorsFilter extends OncePerRequestFilter {

		@Override
		protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
				throws ServletException, IOException {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
			response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
			response.addHeader("Access-Control-Allow-Credentials", "true");

			filterChain.doFilter(request, response);
		}
	}
}
