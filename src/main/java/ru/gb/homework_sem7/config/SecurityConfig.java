package ru.gb.homework_sem7.config;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/* 
	Базовое задание:

	Внимание ДЗ выполнять в версии SpringBoot:3.2.5(на основе example4_sem7)

	Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в зависимости от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.

	Создайте ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN
	Создайте ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от их роли
	Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств Spring Security
	Если неаутентифицированный пользователь пытается получить доступ к /private-data, он должен быть перенаправлен на форму входа
	Подсказка:

	Файл HTML:

	<!DOCTYPE html>
	<html lang="en">
	<head>
	<meta charset="UTF-8">
	<title>Login</title>
	</head>
	<body>
	<h2>Login</h2>
	<form action="/login" method="post">
	<div>
	<label for="username">Username:</label>
	<input type="text" id="username" name="username"/>
	</div>
	<div>
	<label for="password">Password:</label>
	<input type="password" id="password" name="password"/>
	</div>
	<input type="submit" value="Login"/>
	</form>
	</body>
	</html>
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private SuccessHandler mySuccessHandler;

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((authorize) -> authorize
			.requestMatchers("/css/**", "/favicon.ico", "/", "/index", "/public-data/**", "/registr/**")
			.permitAll() // "/css/**", "/", "/index", "/public-data/**", "/register/**"
			.requestMatchers("/user/**").hasAnyRole("USER")
			.requestMatchers("/admin/**").hasAnyRole("ADMIN")
			.requestMatchers("/private-data/**").hasAnyRole("ADMIN")
			// .requestMatchers("/private-data/**").access((authentication, context) ->
    		// 	new AuthorizationDecision(webSecurity.check(authentication.get(), context.getRequest()))) 
			// .requestMatchers(new MyCustomRequestMatcher()).hasRole("ADMIN") 
			.anyRequest().authenticated()
		)
		.formLogin(login -> login
			.defaultSuccessUrl("/")
                        // .successHandler(mySuccessHandler)
                        .permitAll())
		// .exceptionHandling(c ->
		// 				c.authenticationEntryPoint(
		// 						(req, res, ex) -> res.sendRedirect("/registr")))
		.logout(logout -> logout
				.logoutSuccessUrl("/"))
		;
        return http.build(); 
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	UserDetailsManager inMemoryUserDetailsManager() {
		var user1 = User.withUsername("user").password("{noop}pas").roles("USER").build();
		var user2 = User.withUsername("admin").password("{noop}pas").roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user1, user2); 
	}

}
