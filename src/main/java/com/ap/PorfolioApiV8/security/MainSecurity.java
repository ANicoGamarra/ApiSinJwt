package com.ap.PorfolioApiV8.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    
	///walter jwt token
	

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/login").permitAll()
				.antMatchers(HttpMethod.POST, "/**").authenticated()
				.antMatchers(HttpMethod.PUT, "/**").authenticated()
				.antMatchers(HttpMethod.DELETE, "/**").authenticated();
				
				//.anyRequest().authenticated();
		}
	}
	
	
	/*
    @Autowired
	private JwtEntryPoint jwtEntryPoint;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

    @Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

    @Bean
	public JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		    .exceptionHandling()
		    .authenticationEntryPoint(jwtEntryPoint)
		    .and().cors().and()
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
		    .authorizeRequests().antMatchers(HttpMethod.GET, "/**").permitAll()
		    .antMatchers("/api/login").permitAll()
		    .anyRequest()
		    .authenticated();
		http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

    @Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	*/


	
	


