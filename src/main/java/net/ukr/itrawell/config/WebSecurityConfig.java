package net.ukr.itrawell.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().permitAll()
//                .anyRequest().authenticated()
//                .antMatchers("/**").permitAll()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/post/**").access("isAuthenticated() and hasRole('ADMIN')")
//                .antMatchers(HttpMethod.PUT, "/post/**").access("isAuthenticated() and hasRole('ADMIN')")
//                .antMatchers(HttpMethod.DELETE, "/post/**").access("isAuthenticated() and hasRole('ADMIN')")                
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
            .csrf();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }

}
