package com.sevenseven.cashloansystem.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String LENDER = "LENDER";
    private static final String MANAGER = "MANAGER";
    private static final String BORROWER = "BORROWER";

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/page/manager").hasRole(MANAGER)
                .antMatchers("/page/lender").hasRole(LENDER)
                .antMatchers("/page/admin").hasRole(ADMIN)
                .antMatchers("/page/borrower").hasRole(BORROWER)
                .antMatchers("/page/borrower-list").hasRole(ADMIN)
                .antMatchers("/page/official-list").hasRole(ADMIN)
                .antMatchers("/page/teller-list").hasRole(ADMIN)
                .antMatchers("/page/edit-borrower").hasRole(BORROWER)
                .antMatchers("/page/create-borrower").hasRole(BORROWER)
                .antMatchers("/page/add-teller").hasRole(ADMIN)
                .antMatchers("/page/edit-teller").hasRole(ADMIN)
                .antMatchers("/page/add-official").hasRole(ADMIN)
                .antMatchers("/page/disable-official").hasRole(ADMIN)
                .antMatchers("/page/current-interest-rate").hasRole(LENDER)
                .antMatchers("/page/approve-loan-request").hasRole(LENDER)
                .antMatchers("/page/disapproved-loan-request").hasRole(LENDER)
                .antMatchers("/page/view-request").hasRole(LENDER)
                .antMatchers("/page/edit-request").hasRole(ADMIN)
                .antMatchers("/page/delete-request").hasRole(ADMIN)
                .antMatchers("/page/loan-request").hasRole(MANAGER)
                .antMatchers("/page/borrowers-record").hasRole(MANAGER)
                .antMatchers("/page/review-loan").hasRole(MANAGER)
                .antMatchers("/page/update-loan").hasRole(MANAGER)
                .antMatchers("/page/submit-loan").hasRole(MANAGER)
                .antMatchers("/page/register").hasRole(BORROWER)
                .antMatchers("/page/edit-info").hasRole(BORROWER)
                .antMatchers("/page/cancel-request").hasRole(BORROWER)
                .antMatchers("/page/edit-loan-request").hasRole(BORROWER)
                .antMatchers("/page/current-request").hasRole(BORROWER)
                .antMatchers("/page/old-request").hasRole(BORROWER)
                .antMatchers("/page/all").permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
                .logout()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}