package it.prova.pizzastore.web.servlet.ingrediente;

import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.StatoUtente;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component

public class PrepareSearchIngredienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IngredienteService ingredienteService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ingrediente> ingredienti = ingredienteService.listAllElements();
        request.setAttribute("ingredienti_list_attribute", ingredienti);
        request.getRequestDispatcher("/ingrediente/search.jsp").forward(request, response);
    }

}
