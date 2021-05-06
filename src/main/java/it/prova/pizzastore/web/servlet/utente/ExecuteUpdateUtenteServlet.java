package it.prova.pizzastore.web.servlet.utente;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.Utente;
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
public class ExecuteUpdateUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	public ExecuteUpdateUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confermaPasswordParam = request.getParameter("confermaPassword");
		String[] ruoliParam = request.getParameterValues("ruolo.id");

		try {

			long idUtente = Long.parseLong(idParam);
			boolean isTheLast = utenteService.isTheLastAdministrator(idUtente);
			Utente utentePreModifica = utenteService.caricaSingoloUtente(idUtente);

			UtenteDTO utenteInstance = UtenteDTO.createUtenteDTOFromInsertParams(usernameParam, passwordParam,
					nomeParam, cognomeParam, ruoloService.findByArrayIdParam(ruoliParam));
			utenteInstance.setId(Long.parseLong(idParam));
			utenteInstance.setDateCreated(utentePreModifica.getDateCreated());
			utenteInstance.setStato(utentePreModifica.getStato());

			utenteInstance.validate();

			if (utenteInstance.hasErrors()) {
				request.setAttribute("utenteDaModificare", utenteInstance);
				request.setAttribute("ruoli_list_attribute", ruoloService.listAll());
				request.getRequestDispatcher("/utente/edit.jsp").forward(request, response);
				return;
			}

			if (!passwordParam.equals(confermaPasswordParam) || isTheLast) {
				utenteInstance.setRuoli(utentePreModifica.getRuoli());
				request.setAttribute("utenteDaModificare", utenteInstance);
				request.setAttribute("ruoli_list_attribute", ruoloService.listAll());

				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione nella password");
				request.getRequestDispatcher("/utente/edit.jsp").forward(request, response);
				return;

			}

			utenteService.aggiorna(utenteInstance.buildUtenteModel());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}

}
