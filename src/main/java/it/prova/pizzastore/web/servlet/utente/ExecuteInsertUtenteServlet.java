package it.prova.pizzastore.web.servlet.utente;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private UtenteService utenteService;

	public ExecuteInsertUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confermaPasswordParam = request.getParameter("confermaPassword");
		String[] ruoliParam = request.getParameterValues("ruolo.id");

		try {
			UtenteDTO utenteInstance = UtenteDTO.createUtenteDTOFromInsertParams(usernameParam, passwordParam,
					nomeParam, cognomeParam, ruoloService.findByArrayIdParam(ruoliParam));

			if (!passwordParam.equals(confermaPasswordParam)) {
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione nella password");
				request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
				return;
			}

			utenteInstance.validate();
			if (utenteInstance.hasErrors()) {
				request.setAttribute("insert_utente_attr", utenteInstance);
				request.setAttribute("ruoli_list_attribute", ruoloService.listAll());
				request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
				return;
			}

			utenteService.inserisciNuovo(utenteInstance.buildUtenteModel());
			request.setAttribute("utenti_list_attribute",
					UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti()));

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}

}
