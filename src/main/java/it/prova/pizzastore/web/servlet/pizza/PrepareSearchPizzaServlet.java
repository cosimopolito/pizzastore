package it.prova.pizzastore.web.servlet.pizza;

import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class PrepareSearchPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Ingrediente> ingredienti = ingredienteService.listAllElements();
		request.setAttribute("ingredienti_list_attr", ingredienti);
		request.getRequestDispatcher("/pizza/search.jsp").forward(request, response);
	}

}
