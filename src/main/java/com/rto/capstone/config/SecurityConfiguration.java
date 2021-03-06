package com.rto.capstone.config;

import com.rto.capstone.services.UserDetailsLoader;
import com.rto.capstone.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                    .loginPage("/users/login")
                    .defaultSuccessUrl("/profile") // user's home page, it can be any URL
                    .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                    .logout()
                    .logoutSuccessUrl("/users/login?logout") // append a query string value
                /* Pages that can be viewed without having to log in */
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/search", "/places") // anyone can see the home, search results and individual postings
                    .permitAll()
                /* Pages that require authentication */
                .and()
                    .authorizeRequests()
                    .antMatchers(
                        "/places/create", // only authenticated users can create places
                        "/confirmation/**","/profile/{id}", "/profile", "/place/{id}"
                            //they can only go to prof if logged in

                            // only authenticated users can checkout
                    )
                    .authenticated()
        ;
    }
}