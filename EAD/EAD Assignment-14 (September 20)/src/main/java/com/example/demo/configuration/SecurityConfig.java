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
import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
    DataSource dataSource;

	//Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
	
	
	
	
	
	
	
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.inMemoryAuthentication()
//        .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
//        .and()
//        .withUser("admin").password(passwordEncoder().encode("123")).roles("ADMIN");
//    }
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     //Secure the end points with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests() 
        .antMatchers("/welcome").permitAll()
        .antMatchers("/addStudent").access("hasRole('ADMIN')")
		.antMatchers("/userread").access("hasRole('ADMIN')or hasRole('USER')")
		.antMatchers("/userupdate").access("hasRole('ADMIN')or hasRole('USER')")
		.antMatchers("/adminread").access("hasRole('ADMIN')")
		.antMatchers("/showemail").access("hasRole('ADMIN')")
		.and()
		.formLogin().loginPage("/index")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/index")
		.failureUrl("/login?error=true")
		.and()
        .csrf()
        .disable();
    
    }



}