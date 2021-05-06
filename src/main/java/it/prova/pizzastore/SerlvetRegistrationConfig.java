package it.prova.pizzastore;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.ingrediente.*;
import it.prova.pizzastore.web.servlet.pizza.PrepareSearchPizzaServlet;
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
    @Autowired
    private PrepareSearchIngredienteServlet prepareSearchIngredienteServlet;
    @Autowired
    private ExecuteSearchIngredienteServlet executeSearchIngredienteServlet;
    @Autowired
    private ExecuteVisualizzaIngredienteServlet executeVisualizzaIngredienteServlet;
    @Autowired
    private ExecuteListIngredienteServlet executeListIngredienteServlet;
    @Autowired
    private PrepareInsertIngredienteServlet prepareInsertIngredienteServlet;
    @Autowired
    private ExecuteInsertIngredienteServlet executeInsertIngredienteServlet;
    @Autowired
    private PrepareModificaIngredienteServlet prepareModificaIngredienteServlet;
    @Autowired
    private ExecuteModificaIngredienteServlet executeModificaIngredienteServlet;
    @Autowired
    private PrepareSearchPizzaServlet prepareSearchPizzaServlet;

    @Bean
    public ServletRegistrationBean<PrepareSearchPizzaServlet> createPrepareSearchPizzaServletBean() {
        ServletRegistrationBean<PrepareSearchPizzaServlet> bean = new ServletRegistrationBean<PrepareSearchPizzaServlet>(
                prepareSearchPizzaServlet, "/pizza/PrepareSearchPizzaServlet");
        return bean;
    }


    @Bean
    public ServletRegistrationBean<ExecuteModificaIngredienteServlet> createExecuteModificaIngredienteServletBean() {
        ServletRegistrationBean<ExecuteModificaIngredienteServlet> bean = new ServletRegistrationBean<ExecuteModificaIngredienteServlet>(
                executeModificaIngredienteServlet, "/ingrediente/ExecuteModificaIngredienteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<PrepareModificaIngredienteServlet> createPrepareModificaIngredienteServletBean() {
        ServletRegistrationBean<PrepareModificaIngredienteServlet> bean = new ServletRegistrationBean<PrepareModificaIngredienteServlet>(
                prepareModificaIngredienteServlet, "/ingrediente/PrepareModificaIngredienteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<ExecuteInsertIngredienteServlet> createExecuteInsertIngredienteServletBean() {
        ServletRegistrationBean<ExecuteInsertIngredienteServlet> bean = new ServletRegistrationBean<ExecuteInsertIngredienteServlet>(
                executeInsertIngredienteServlet, "/ingrediente/ExecuteInsertIngredienteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<PrepareInsertIngredienteServlet> createPrepareInsertIngredienteServletBean() {
        ServletRegistrationBean<PrepareInsertIngredienteServlet> bean = new ServletRegistrationBean<PrepareInsertIngredienteServlet>(
                prepareInsertIngredienteServlet, "/ingrediente/PrepareInsertIngredienteServlet");
        return bean;
    }



    @Bean
    public ServletRegistrationBean<ExecuteListIngredienteServlet> createExecuteListIngredienteServletBean() {
        ServletRegistrationBean<ExecuteListIngredienteServlet> bean = new ServletRegistrationBean<ExecuteListIngredienteServlet>(
                executeListIngredienteServlet, "/ingrediente/ExecuteListIngredienteServlet");
        return bean;
    }

    @Bean
    public ServletRegistrationBean<ExecuteVisualizzaIngredienteServlet> createExecuteVisualizzaIngredienteServletBean() {
        ServletRegistrationBean<ExecuteVisualizzaIngredienteServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaIngredienteServlet>(
                executeVisualizzaIngredienteServlet, "/ingrediente/ExecuteVisualizzaIngredienteServlet");
        return bean;
    }


    @Bean
    public ServletRegistrationBean<ExecuteSearchIngredienteServlet> createExecuteSearchIngredienteServletBean() {
        ServletRegistrationBean<ExecuteSearchIngredienteServlet> bean = new ServletRegistrationBean<ExecuteSearchIngredienteServlet>(
                executeSearchIngredienteServlet, "/ingrediente/ExecuteSearchIngredienteServlet");
        return bean;
    }


    @Bean
    public ServletRegistrationBean<PrepareSearchIngredienteServlet> createPrepareSearchIngredienteServletBean() {
        ServletRegistrationBean<PrepareSearchIngredienteServlet> bean = new ServletRegistrationBean<PrepareSearchIngredienteServlet>(
                prepareSearchIngredienteServlet, "/ingrediente/PrepareSearchIngredienteServlet");
        return bean;
    }


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
