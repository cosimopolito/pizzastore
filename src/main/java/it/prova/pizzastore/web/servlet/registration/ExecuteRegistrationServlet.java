package it.prova.pizzastore.web.servlet.registration;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class ExecuteRegistrationServlet extends HttpServlet {
    @Autowired
    private UtenteService utenteService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeParam = request.getParameter("nome");
        String cognomeParam = request.getParameter("cognome");
        String usernameParam = request.getParameter("username");
        String passwordParam = request.getParameter("password");
        String passwordRepeatParam = request.getParameter("passwordRepeat");

        UtenteDTO utenteDTOInstance = UtenteDTO.createUtenteDTOFromRegistrationParams(nomeParam, cognomeParam, usernameParam,
                passwordParam);
        utenteDTOInstance.setDateCreated(new Date());

        if (!passwordParam.equals(passwordRepeatParam)) {
            request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione nella password");
            request.getRequestDispatcher("/registration/registration.jsp").forward(request, response);
            return;
        }
        utenteDTOInstance.validate();

        try {
            // se la validazione non risulta ok
            if (utenteDTOInstance.hasErrors()) {
                request.setAttribute("registration_utente_attr", utenteDTOInstance);

                request.getRequestDispatcher("/registration/registration.jsp").forward(request, response);
                return;
            }

            // se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
            // occupiamoci delle operazioni di business
            utenteService.inserisciNuovo(utenteDTOInstance.buildUtenteModel());
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        response.sendRedirect("../login.jsp");
    }

}
