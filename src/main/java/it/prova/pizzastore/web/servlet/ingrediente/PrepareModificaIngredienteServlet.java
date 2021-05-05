package it.prova.pizzastore.web.servlet.ingrediente;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.service.IngredienteService;
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
public class PrepareModificaIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public PrepareModificaIngredienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idIngrediente");

		try {
			
			request.setAttribute("ingredienteDaModificare",
					IngredienteDTO.buildIngredienteDTOFromModel(ingredienteService.caricaSingoloElemento(Long.parseLong(idParam))));

			RequestDispatcher rd = request.getRequestDispatcher("/ingrediente/edit.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}

}
