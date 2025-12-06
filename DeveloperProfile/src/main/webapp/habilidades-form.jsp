<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.developerprofile.model.Habilidad" %>

<%
    Habilidad h = (Habilidad) request.getAttribute("habilidad");
    boolean modoEdicion = (h != null);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><%= modoEdicion ? "Editar Habilidad" : "Nueva Habilidad" %></title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
        />
    </head>

    <body class="bg-light">

        <div class="container mt-5">

            <h2 class="mb-4 text-center">
                <%= modoEdicion ? "Editar habilidad" : "Agregar nueva habilidad" %>
            </h2>

            <form action="HabilidadAddServlet" method="post" class="card p-4 shadow-sm">

                <input type="hidden" name="action" value="<%= modoEdicion ? "actualizar" : "insertar" %>">

                <% if (modoEdicion) { %>
                    <input type="hidden" name="id" value="<%= h.getId() %>">
                <% } %>

                <div class="mb-3">
                    <label class="form-label">Nombre de la habilidad</label>
                    <input type="text" name="nombre" class="form-control"
                        value="<%= modoEdicion ? h.getNombre() : "" %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Nivel</label>
                    <select name="nivel" class="form-select" required>
                        <option value="">Seleccione un nivel</option>
                        <option value="Básico" <%= modoEdicion && h.getNivel().equals("Básico") ? "selected" : "" %>>Básico</option>
                        <option value="Intermedio" <%= modoEdicion && h.getNivel().equals("Intermedio") ? "selected" : "" %>>Intermedio</option>
                        <option value="Avanzado" <%= modoEdicion && h.getNivel().equals("Avanzado") ? "selected" : "" %>>Avanzado</option>
                    </select>
                </div>

                <div class="d-flex justify-content-between">
                    <a href="HabilidadController?action=listar" class="btn btn-secondary">Volver</a>
                    <button type="submit" class="btn btn-success">
                        <%= modoEdicion ? "Actualizar" : "Guardar" %>
                    </button>
                </div>

            </form>
        </div>

    </body>
</html>
