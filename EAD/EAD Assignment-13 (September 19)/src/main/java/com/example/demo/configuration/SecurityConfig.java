package com.example.demo.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
        .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123")).roles("ADMIN");
    }
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Secure the end points with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/welcome").permitAll()
        .antMatchers("/index").authenticated()
		.antMatchers("/addStudent").access("hasRole('ADMIN')")
		.antMatchers("/showStudent").access("hasRole('USER')")
		.antMatchers("/emailSearch").access("hasRole('ADMIN')or hasRole('USER')")
		.antMatchers("/showemail").access("hasRole('ADMIN')or hasRole('USER')")
		.and()
		.formLogin().loginPage("/index")
		.defaultSuccessUrl("/index")
		.failureUrl("/login?error=true")
		.usernameParameter("username").passwordParameter("password")				
		.and()
        .csrf()
        .disable();
    
    }



}