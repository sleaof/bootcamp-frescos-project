package com.mercadolibre.dambetan01.config;

import com.mercadolibre.dambetan01.security.JWTAuthorizationFilter;
import lombok.Builder;
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
                .antMatchers(HttpMethod.GET, "/ping").permitAll()
                .antMatchers(HttpMethod.GET, "/v3/api-docs").permitAll()
                .antMatchers(HttpMethod.GET, "/fake").permitAll()
                //Seller-Buyer
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/list").hasRole("USER")
                //RF-006 Stephanie Leao
                .antMatchers(HttpMethod.GET, "/top-selling-products").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/fresh-products/orders/").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/fresh-products/orders/").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/fresh-products/orders").hasRole("USER")

                //Representante
                .antMatchers(HttpMethod.POST,"/api/v1/fresh-products/inbounded/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v1/fresh-products/inbounded/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/fresh-products/list/warehouse").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/fresh-products/warehouse/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/fresh-products/due-date/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/fresh-products/due-date/list/").hasRole("ADMIN")
                //RF-006 Gabriel Borba Paim
                .antMatchers(HttpMethod.GET,"/inboud-order/betweendate").hasRole("ADMIN")
                .anyRequest().authenticated();
        //.and()
        //      .addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);

    }
}
