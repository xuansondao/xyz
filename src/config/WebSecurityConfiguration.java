package config;

import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vn.com.vndirect.vndid.auth.AuthFilter;
import vn.com.vndirect.vndid.auth.LoginFilter;
import vn.com.vndirect.vndid.auth.LogoutAuth;
import vn.com.vndirect.vndid.security.RepoSecurityConfigurerAdapter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends RepoSecurityConfigurerAdapter {

    public WebSecurityConfiguration(HttpClient httpClient, Environment env) {
        super(env.getProperty("domain.vnds", "VNDS"), httpClient, env);
    }

    @Override
    public AuthFilter createAuthFilter() {
        return new AuthFilter(authenticationService);
    }

    @Override
    public LoginFilter createLoginFilter() {
        AntPathRequestMatcher loginPathMatcher = new AntPathRequestMatcher("/login");
        return new LoginFilter(authenticationService, loginPathMatcher) {
            @Override
            public void doFilter(ServletRequest request, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
                super.doFilter(request, arg1, arg2);
            }

            @Override
            public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
                    throws AuthenticationException, IOException, ServletException {
                return super.attemptAuthentication(request, response);
            }
        };
    }

    @Override
    public LogoutFilter createLogoutFilter() {
        LogoutAuth logoutAuth = new LogoutAuth(authenticationService);
        logoutAuth.setFilterProcessesUrl("/logout");
        return logoutAuth;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("login", "logout")
                .antMatchers(HttpMethod.GET,
                        "/actuator/info", "/actuator/health",
                        "/index/**", "/brains/usn/internal/**", "/broker-audit/**",
                        "/brains/internal/**", "/brains/internal/broker",
                        "/brains/usn/internal/broker/**", "/brains/internal/customerId/**","/brains/internal")
                .antMatchers(HttpMethod.PATCH, "/brains/broker/**")
                .antMatchers(HttpMethod.POST, "/brains")
                .antMatchers(HttpMethod.DELETE, "/brains/**");
    }
}