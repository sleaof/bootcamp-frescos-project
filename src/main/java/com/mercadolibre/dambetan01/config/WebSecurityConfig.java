package com.mercadolibre.dambetan01.config;

import com.mercadolibre.dambetan01.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/sign-in").permitAll()

                .antMatchers(HttpMethod.GET, "/ping").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api/v1/inboudOrderHasBatchOnDate").permitAll()
                .antMatchers(HttpMethod.GET, "/ping").hasRole("ADMIN")
                //.antMatchers(HttpMethod.GET, "/v3/api-docs").permitAll()
                .antMatchers(HttpMethod.GET, "/v3/api-docs").hasRole("USER")

                .antMatchers(HttpMethod.GET, "/fake").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v1/fresh-products/inbounded/").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/v1/fresh-products/inbounded/").permitAll()
                .anyRequest().authenticated();
        //.and()
          //      .addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);

    }
}
