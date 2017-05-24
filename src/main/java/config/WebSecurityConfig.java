package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rit.enrollment.logic.CustomUserDetailsService;
import com.rit.enrollment.repository.UserRepository;


@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses= CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepository;
	
	public UserDetailsService userDetailsServiceBean(){
		return new CustomUserDetailsService(userRepository);
	}
	
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsServiceBean());
		auth.authenticationProvider(authProvider());
	}
	@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(this.userDetailsServiceBean());
	    authProvider.setPasswordEncoder(passwordEncoder());

	    return authProvider;
	}
	
	public void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/myCoursesDepartment").hasAnyAuthority("head")
		.antMatchers("/myCoursesFaculty").hasAnyAuthority("faculty")
		.antMatchers("/myCoursesStudent").hasAnyAuthority("student")
		.antMatchers("/login").anonymous()
		.anyRequest().fullyAuthenticated()
		.and() 
		.formLogin()
		.loginPage("/login")
		.successForwardUrl("/coursesList")
		.defaultSuccessUrl("/coursesList", true)
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout.done").deleteCookies("JSESSIONID")
		.invalidateHttpSession(true);
	
	}
	
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(10);
	}
}
