package it.prova.pizzastore.web.servlet.ingrediente;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.service.IngredienteService;
import it.prova.pizzastore.service.UtenteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExecuteListIngredienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Autowired
    private IngredienteService ingredienteService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operationResult = request.getParameter("operationResult");
            if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("SUCCESS"))
                request.setAttribute("successMessage", "Operazione effettuata con successo");
            if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("NOT_FOUND"))
                request.setAttribute("errorMessage", "Elemento non trovato");

            request.setAttribute("ingrediente_list_attribute",
                    IngredienteDTO.createIngredienteDTOListFromModelList(ingredienteService.listAllElements()));
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("/ingrediente/list.jsp").forward(request, response);
    }

}
