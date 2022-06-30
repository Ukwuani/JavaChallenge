package com.works.emr.security;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import com.works.emr.staff.StaffEntity;
import com.works.emr.staff.StaffService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security {
    @Autowired
    private StaffService staffService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        PreAuthTokenHeaderFilter filter = new PreAuthTokenHeaderFilter("Authorization");

        filter.setAuthenticationManager(new AuthenticationManager()
        {
            @Override
            public Authentication authenticate(Authentication authentication)
                    throws AuthenticationException
            {

                String principal = authentication.getPrincipal().toString();
                String uuid = principal.replace("Bearer","").trim();
                StaffEntity userInDB = staffService.getStaff(uuid);

                if (Objects.isNull(userInDB)) {
                    throw new BadCredentialsException("Unauthorized identity");
                }
                authentication.setAuthenticated(true);
                return authentication;
            }
        });
        
        http
            .csrf().disable()
            .cors().disable()
            .sessionManagement()
            	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(filter)
            .addFilterBefore(new ExceptionTranslationFilter(
                new Http403ForbiddenEntryPoint()), 
                    filter.getClass()
            )
            .authorizeHttpRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.POST, "/v1/api/staff").permitAll()
            .anyRequest()
            .authenticated();
        return http.build();
    }
}


