package com.bolsasdeidead.springboot.backend.apirest.auth;

import java.util.Arrays;

import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/alumnos").permitAll() // dando permisos
				// HasAnyRole es mucho roles ,hasRole un solo rol
				/*
				 * .antMatchers(HttpMethod.GET,"/api/alumnos/{id}").hasAnyRole("USER","ADMIN")
				 * .antMatchers(HttpMethod.POST,"/api/alumnos").hasRole("ADMIN")
				 * .antMatchers(HttpMethod.GET,"/api/alumnos/**").hasRole("ADMIN")
				 */

				.anyRequest().authenticated()
				.and().cors().configurationSource(corsConfigurationSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080")); // Lista de orígenes permitidos
	    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Métodos HTTP permitidos
	    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Cabeceras permitidas
	    configuration.setAllowCredentials(true); // Permitir credenciales

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration); // Aplicar configuración a todas las rutas

	    return source;
	}

	// configuramos un filtro

	  @Bean
	    public FilterRegistrationBean<CorsFilter> corsFilter() {
	        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
	        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	        return bean;
	    }
}
