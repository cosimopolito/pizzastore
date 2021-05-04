package it.prova.pizzastore;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.registration.ExecuteRegistrationServlet;
import it.prova.pizzastore.web.servlet.utente.*;
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
    @Autowired
    private PrepareSearchUtenteServlet prepareSearchUtenteServlet;
    @Autowired
    private ExecuteSearchUtenteServlet executeSearchUtenteServlet;
    @Autowired
    private ExecuteVisualizzaUtenteServlet executeVisualizzaUtenteServlet;
    @Autowired
    private ExecuteListUtenteServlet executeListUtenteServlet;
    @Autowired
    private ExecuteCambiaStatoUtenteServlet executeCambiaStatoUtenteServlet;
    @Autowired
    private PrepareInsertUtenteServlet prepareInsertUtenteServlet;
    @Autowired
    private ExecuteInsertUtenteServlet executeInsertUtenteServlet;
    @Autowired
    private PrepareUpdateUtenteServlet prepareUpdateUtenteServlet;
    @Autowired
    private ExecuteUpdateUtenteServlet executeUpdateUtenteServlet;

    @Bean
    public ServletRegistrationBean<ExecuteUpdateUtenteServlet> createExecuteUpdateUtenteServletBean() {
        ServletRegistrationBean<ExecuteUpdateUtenteServlet> bean = new ServletRegistrationBean<ExecuteUpdateUtenteServlet>(
                executeUpdateUtenteServlet, "/utente/ExecuteUpdateUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<PrepareUpdateUtenteServlet> createPrepareUpdateUtenteServletBean() {
        ServletRegistrationBean<PrepareUpdateUtenteServlet> bean = new ServletRegistrationBean<PrepareUpdateUtenteServlet>(
                prepareUpdateUtenteServlet, "/utente/PrepareUpdateUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<ExecuteInsertUtenteServlet> createExecuteInsertUtenteServletBean() {
        ServletRegistrationBean<ExecuteInsertUtenteServlet> bean = new ServletRegistrationBean<ExecuteInsertUtenteServlet>(
                executeInsertUtenteServlet, "/utente/ExecuteInsertUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<PrepareInsertUtenteServlet> createPrepareInsertUtenteServletBean() {
        ServletRegistrationBean<PrepareInsertUtenteServlet> bean = new ServletRegistrationBean<PrepareInsertUtenteServlet>(
                prepareInsertUtenteServlet, "/utente/PrepareInsertUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet> createExecuteCambiaStatoUtenteServletBean() {
        ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet> bean = new ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet>(
                executeCambiaStatoUtenteServlet, "/utente/ExecuteCambiaStatoUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<ExecuteListUtenteServlet> createExecuteListUtenteServletBean() {
        ServletRegistrationBean<ExecuteListUtenteServlet> bean = new ServletRegistrationBean<ExecuteListUtenteServlet>(
                executeListUtenteServlet, "/utente/ExecuteListUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<ExecuteVisualizzaUtenteServlet> createExecuteVisualizzaUtenteServletBean() {
        ServletRegistrationBean<ExecuteVisualizzaUtenteServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaUtenteServlet>(
                executeVisualizzaUtenteServlet, "/utente/ExecuteVisualizzaUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<ExecuteSearchUtenteServlet> createExecuteSearchUtenteServletBean() {
        ServletRegistrationBean<ExecuteSearchUtenteServlet> bean = new ServletRegistrationBean<ExecuteSearchUtenteServlet>(
                executeSearchUtenteServlet, "/utente/ExecuteSearchUtenteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<PrepareSearchUtenteServlet> createPrepareSearchUtenteServletBean() {
        ServletRegistrationBean<PrepareSearchUtenteServlet> bean = new ServletRegistrationBean<PrepareSearchUtenteServlet>(
                prepareSearchUtenteServlet, "/utente/PrepareSearchUtenteServlet");
        return bean;
    }

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
