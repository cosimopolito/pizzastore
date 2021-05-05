package it.prova.pizzastore.web.servlet.ingrediente;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExecuteInsertIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public ExecuteInsertIngredienteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descrizioneParam = request.getParameter("descrizione");
		String prezzoParam = request.getParameter("prezzo");
		String codiceParam = request.getParameter("codice");

		try {
			IngredienteDTO ingredienteInstance = IngredienteDTO.createIngredienteDTOFromParams(descrizioneParam, prezzoParam,
					codiceParam);



			ingredienteInstance.validate();
			if (ingredienteInstance.hasErrors()) {
				request.setAttribute("insert_ingrediente_attr", ingredienteInstance);
				request.getRequestDispatcher("/ingrediente/insert.jsp").forward(request, response);
				return;
			}

			ingredienteService.inserisciNuovo(ingredienteInstance.buildIngredienteModel());
			request.setAttribute("ingredienti_list_attribute",
					IngredienteDTO.createIngredienteDTOListFromModelList(ingredienteService.listAllElements()));

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/ingrediente/insert.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListIngredienteServlet?operationResult=SUCCESS");
	}

}
