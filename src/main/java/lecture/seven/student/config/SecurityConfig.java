package lecture.seven.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // ЗАДАНИЕ part5_1: настройте правила доступа согласно методическим указаниям.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/api/greet/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/students", "/api/students/*", "/api/students/search").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/students").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/students/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/students/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/students/save").hasRole("ADMIN")
                        .requestMatchers("/students/delete/**").hasRole("ADMIN")
                        .requestMatchers("/students/**").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form.permitAll())
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout.permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
        return http.build();
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // ЗАДАНИЕ part5_1: объясните, почему требуется PasswordEncoder.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return new BCryptPasswordEncoder();
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // ЗАДАНИЕ part5_1: создайте user/password и admin/password с нужными ролями.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}
