package security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
class SecurityConfiguration: WebSecurityConfiguration() {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.securityMatcher()
        http {
            authorizeHttpRequests {
                authorize("/users/get", permitAll)
                authorize(anyRequest, authenticated)
            }
        }
        return http.build()
    }
}