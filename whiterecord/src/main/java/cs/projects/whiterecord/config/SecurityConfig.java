package cs.projects.whiterecord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	 @Override
	  protected void configure(HttpSecurity httpSecurity) throws Exception {
		 httpSecurity.authorizeRequests()

	        .antMatchers("/").permitAll()
	        .and().csrf().disable();
		 httpSecurity.httpBasic().disable();
	  }
}
