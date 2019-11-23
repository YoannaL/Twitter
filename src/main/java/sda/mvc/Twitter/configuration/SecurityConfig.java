package sda.mvc.Twitter.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder bCryptPasswordEndcoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/postform*")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/index*")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/registration*")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/login*")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .defaultSuccessUrl("/index")
                .and()
                .logout().logoutSuccessUrl("/login");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {



   auth.inMemoryAuthentication()
                .withUser("admin")
                .password(bCryptPasswordEndcoder.encode("admin"))
                .roles("ADMIN");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, ‘ROLE_USER’ FROM users WHERE username=?")
                .dataSource(jdbcTemplate.getDataSource())
                .passwordEncoder(bCryptPasswordEndcoder);

}
}



