package it.prova.pizzastore.web.servlet.utente;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.service.UtenteService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExecuteCambiaStatoUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UtenteService utenteService;

	public ExecuteCambiaStatoUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idUtente");

		if (!NumberUtils.isCreatable(idParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		try {
			utenteService.cambiaStato(Long.parseLong(idParam));

			request.setAttribute("utente_list_attribute",
					UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti()));
		} catch (RuntimeException e) {
			e.printStackTrace();
			request.setAttribute("utente_list_attribute",
					UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti()));
			request.setAttribute("errorMessage", "Attenzione non posso eliminare l'ultimo admin.");
			request.getRequestDispatcher("/utente/list.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/utente/list.jsp").forward(request, response);
	}

}
