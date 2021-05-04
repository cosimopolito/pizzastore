package it.prova.pizzastore.web.servlet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.UtenteService;
import it.prova.pizzastore.web.filter.AuthenticationFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		throw new UnsupportedOperationException("Invocation of doGet not allowed for this Servlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginInput = request.getParameter("inputUsername");
		String passwordInput = request.getParameter("inputPassword");

		if (StringUtils.isEmpty(loginInput) || StringUtils.isEmpty(passwordInput)) {
			request.setAttribute("errorMessage", "E' necessario riempire tutti i campi.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		String destinazione = null;

		try {
			Utente utenteInstance = utenteService.eseguiAccesso(loginInput, passwordInput);
			if (utenteInstance == null) {
				destinazione = "login.jsp";
				request.setAttribute("errorMessage", "Utente non trovato.");
			} else {
				for (Ruolo ruolo:utenteInstance.getRuoli() ) {
					if (ruolo.getCodice().equalsIgnoreCase(Ruolo.ROLE_ADMIN) && utenteInstance.getStato() == StatoUtente.ATTIVO){
						AuthenticationFilter.putUserLoggedInSession(request, utenteInstance);
						destinazione = "/admin/homeAdmin.jsp";
						break;
					}
					else if (ruolo.getCodice().equalsIgnoreCase(Ruolo.ROLE_FATTORINO.toString()) && utenteInstance.getStato() == StatoUtente.ATTIVO){
						AuthenticationFilter.putUserLoggedInSession(request, utenteInstance);
						destinazione = "/fattorino/homeFattorino.jsp";
						break;
					}
					else if (ruolo.getCodice().equalsIgnoreCase(Ruolo.ROLE_PIZZAIOLO.toString())&& utenteInstance.getStato() == StatoUtente.ATTIVO){
						AuthenticationFilter.putUserLoggedInSession(request, utenteInstance);
						destinazione = "/pizzaiolo/homePizzaiolo.jsp";
						break;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			destinazione = "login.jsp";
			request.setAttribute("errorMessage", "Attenzione! Si è verificato un errore.");
		}

		request.getRequestDispatcher(destinazione).forward(request, response);

	}

}
