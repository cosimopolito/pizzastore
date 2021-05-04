package it.prova.pizzastore;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.registration.ExecuteRegistrationServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SerlvetRegistrationConfig {
	// N.B. se le servlet usano bean al loro interno vanno affidate a spring
	// altrimenti va bene @WebServlet

    @Autowired
    private LoginServlet loginServlet;
    @Autowired
    private ExecuteRegistrationServlet executeRegistrationServlet;

    @Bean
    public ServletRegistrationBean<ExecuteRegistrationServlet> createExecuteRegistrationServletBean() {
        ServletRegistrationBean<ExecuteRegistrationServlet> bean = new ServletRegistrationBean<ExecuteRegistrationServlet>(executeRegistrationServlet,
                "/registration/ExecuteRegistrationServlet");
        return bean;
    }



    @Bean
    public ServletRegistrationBean<LoginServlet> createLoginServletBean() {
        ServletRegistrationBean<LoginServlet> bean = new ServletRegistrationBean<LoginServlet>(loginServlet,
                "/LoginServlet");
        return bean;
    }

}
