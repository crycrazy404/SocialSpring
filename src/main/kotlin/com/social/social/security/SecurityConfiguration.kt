package com.social.social.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke

@Configuration
@EnableWebSecurity
class SecurityConfiguration{
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf{
                disable()
            }
            authorizeHttpRequests {
                authorize("/login", permitAll)
                authorize("/users/**", permitAll)
                authorize(anyRequest, authenticated)
            }
            formLogin {

            }
            httpBasic {

            }
        }
        return http.build()
    }
}