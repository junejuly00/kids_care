package kr.ac.kopo.kidscare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		String[] permitUri = {"/login","/login/**", "/signup","/signup/**", "/static/**", "/error", "/"};
		
		String[] roles = {"USER", "SITTER"};
		
		return http.authorizeHttpRequests(req -> {
			req.requestMatchers(permitUri).permitAll();
			
			//req.requestMatchers("/kcuser/**").hasRole("USER");
			//req.requestMatchers("/sitter/**").hasRole("SITTER");
			
			req.anyRequest().authenticated();
			
		})
		.formLogin(login -> {
			//login.loginPage("/login");
			login.defaultSuccessUrl("/");
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
		return new PlainPasswordEncoder();
	}
}
