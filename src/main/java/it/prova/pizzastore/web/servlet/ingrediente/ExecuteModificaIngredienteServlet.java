package it.prova.pizzastore.web.servlet.ingrediente;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExecuteModificaIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public ExecuteModificaIngredienteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String descrizioneParam = request.getParameter("descrizione");
		String prezzoParam = request.getParameter("prezzo");
		String codiceParam = request.getParameter("codice");

		try {

			long idIngrediente = Long.parseLong(idParam);
			Ingrediente ingredienteInstance = ingredienteService.caricaSingoloElemento(idIngrediente);

			IngredienteDTO ingredienteDaValidare = IngredienteDTO.createIngredienteDTOFromParams(idParam, descrizioneParam,
					prezzoParam, codiceParam);

			ingredienteDaValidare.validate();

			if (ingredienteDaValidare.hasErrors()) {
				request.setAttribute("ingrediomteDaModificare", ingredienteDaValidare);
				request.getRequestDispatcher("/ingrediente/edit.jsp").forward(request, response);
				return;
			}

			ingredienteService.aggiorna(ingredienteDaValidare.buildIngredienteModel());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListIngredienteServlet?operationResult=SUCCESS");
	}

}
