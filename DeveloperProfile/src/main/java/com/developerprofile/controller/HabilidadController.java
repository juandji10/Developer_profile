package com.developerprofile.controller;

import com.developerprofile.dao.HabilidadDAO;
import com.developerprofile.model.Habilidad;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/HabilidadController")
public class HabilidadController extends HttpServlet {

    private HabilidadDAO dao;

    @Override
    public void init() {
        dao = new HabilidadDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "nuevo":
                // abrir formulario vacío
                req.getRequestDispatcher("/views/habilidad-form.jsp").forward(req, resp);
                break;

            case "editar":
                String id = req.getParameter("id");
                Habilidad h = dao.obtenerPorId(id); 
                req.setAttribute("habilidad", h);
                req.getRequestDispatcher("/views/habilidad-form.jsp").forward(req, resp);
                break;

            case "listar":
            default:
                List<Habilidad> lista = dao.listarHabilidades();
                req.setAttribute("habilidades", lista);
                req.getRequestDispatcher("/views/habilidades.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("insertar".equals(action)) {
            String nombre = req.getParameter("nombre");
            String nivelStr = req.getParameter("nivel");
            int nivel = 0;
            try { nivel = Integer.parseInt(nivelStr); } catch (Exception e) { nivel = 0; }

            Habilidad h = new Habilidad(nivel, null, nombre); // constructor: nivel,id,nombre
            dao.agregarHabilidad(h);

            resp.sendRedirect(req.getContextPath() + "/HabilidadController?action=listar");
            return;
        }

        if ("actualizar".equals(action)) {
            String id = req.getParameter("id");
            String nombre = req.getParameter("nombre");
            String nivelStr = req.getParameter("nivel");
            int nivel = 0;
            try { nivel = Integer.parseInt(nivelStr); } catch (Exception e) { nivel = 0; }

            dao.editarHabilidad(id, nombre, nivel);
            resp.sendRedirect(req.getContextPath() + "/HabilidadController?action=listar");
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/HabilidadController?action=listar");
    }
}

