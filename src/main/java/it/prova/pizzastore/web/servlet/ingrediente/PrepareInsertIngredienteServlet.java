package it.prova.pizzastore.web.servlet.ingrediente;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.service.IngredienteService;
import it.prova.pizzastore.service.RuoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class PrepareInsertIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IngredienteService ingredienteService;

	public PrepareInsertIngredienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Ingrediente> ingredienti = ingredienteService.listAllElements();
		request.setAttribute("ingredienti_list_attribute", ingredienti);
		request.setAttribute("insert_ingrediente_attr", new IngredienteDTO());
		request.getRequestDispatcher("/ingrediente/insert.jsp").forward(request, response);
	}

}
