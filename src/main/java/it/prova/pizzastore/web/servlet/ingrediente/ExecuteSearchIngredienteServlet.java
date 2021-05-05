package it.prova.pizzastore.web.servlet.ingrediente;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.service.IngredienteService;
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
public class ExecuteSearchIngredienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IngredienteService ingredienteService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descrizioneParam = request.getParameter("descrizione");
        String prezzoParam = request.getParameter("prezzo");
        String codiceParam = request.getParameter("codice");


        try {
            IngredienteDTO ingredienteInstance = IngredienteDTO.createIngredienteDTOFromParams(descrizioneParam, prezzoParam, codiceParam);

            request.setAttribute("ingrediente_list_attribute", IngredienteDTO
                    .createIngredienteDTOListFromModelList(ingredienteService.findByExample(ingredienteInstance.buildIngredienteModel())));

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/ingrediente/list.jsp").forward(request, response);
    }

}
