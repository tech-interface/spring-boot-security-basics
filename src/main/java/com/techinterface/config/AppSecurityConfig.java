package com.techinterface.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    // Basic configuration without roles and username,password

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }*/

    // Advance  configuration with roles and username,password
     @Override
     protected void configure(HttpSecurity http) throws Exception
     {
         http.authorizeRequests().antMatchers("/").permitAll()
                 .antMatchers("/homepage").hasAnyRole("USER", "ADMIN")
                 .antMatchers("/adminHomePage").hasAnyRole( "ADMIN")
                 .antMatchers("/user/*").hasAnyRole("USER")
                 .anyRequest().authenticated().and().formLogin()
                 .permitAll().and()
                 .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();

         http.csrf().disable();
     }

      @Autowired
      public void configureGlobal(AuthenticationManagerBuilder auth)
              throws Exception
      {
          auth.inMemoryAuthentication()
                  .withUser("user")
                  .password("{noop}user")
                  .roles("USER").and()
                   .withUser("admin")
                  .password("{noop}admin")
                  .roles("ADMIN");
      }


    // When we enable @Enablewebsecurity at global level along with configuration

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");

    }*/

}
