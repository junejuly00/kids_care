package kr.ac.kopo.kidscare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		String[] permitUri = {"/**"}; //{"/login", "/signup", "/static/**", "/error","/"};
		return http.authorizeHttpRequests(req -> {
						req.requestMatchers(permitUri).permitAll();
						req.anyRequest().authenticated();
					})
					.oauth2Login(Customizer.withDefaults())
					.formLogin(login -> {
						login.loginPage("/login");
						login.defaultSuccessUrl("/secured");
					})
					.logout(logout -> {
						logout.logoutSuccessUrl("/");
						logout.invalidateHttpSession(true);
					})
					.csrf(csrf -> csrf.disable())
					.build();
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
