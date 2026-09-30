package com.digitalbank.fraud.config;
import org.springframework.context.annotation.*; import org.springframework.security.config.Customizer; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.web.SecurityFilterChain;
@Configuration public class SecurityConfig {
 @Bean SecurityFilterChain security(HttpSecurity h)throws Exception{return h.csrf(c->c.disable()).authorizeHttpRequests(a->a.requestMatchers("/actuator/health","/swagger-ui/**","/v3/api-docs/**","/h2-console/**").permitAll().anyRequest().authenticated()).httpBasic(Customizer.withDefaults()).headers(x->x.frameOptions(f->f.sameOrigin())).build();}
}
