package com.developerprofile.controller;

import com.developerprofile.dao.HabilidadDAO;
import com.developerprofile.model.Habilidad;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HabilidadAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String nombre = request.getParameter("nombre");
        String nivel = request.getParameter("nivel");
        HabilidadDAO dao = new HabilidadDAO();

        if ("insertar".equals(action)) {

            Habilidad h = new Habilidad(nivel, null, nombre);
            dao.agregarHabilidad(h);

        } else if ("actualizar".equals(action)) {

            String id = request.getParameter("id");
            dao.editarHabilidad(id, nombre);

        }

        response.sendRedirect("habilidades");
    }
}
