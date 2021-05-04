package it.prova.pizzastore.web.servlet.utente;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PrepareUpdateUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	public PrepareUpdateUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idUtente");

		try {
			
			request.setAttribute("utenteDaModificare",
					UtenteDTO.buildUtenteDTOFromModel(utenteService.findOneEager(Long.parseLong(idParam))));
			request.setAttribute("ruoli_list_attribute", ruoloService.listAll());
			
			RequestDispatcher rd = request.getRequestDispatcher("/utente/edit.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
	}

}
