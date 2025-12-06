<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.developerprofile.model.Habilidad" %>

<%
    Habilidad h = (Habilidad) request.getAttribute("habilidad");
    boolean modoEdicion = (h != null);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title><%= modoEdicion ? "Editar Habilidad" : "Nueva Habilidad" %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2><%= modoEdicion ? "Editar habilidad" : "Agregar nueva habilidad" %></h2>

    <form action="<%= request.getContextPath() %>/HabilidadController" method="post" class="card p-4">
        <input type="hidden" name="action" value="<%= modoEdicion ? "actualizar" : "insertar" %>">
        <% if (modoEdicion) { %>
            <input type="hidden" name="id" value="<%= h.getId() %>">
        <% } %>

        <div class="mb-3">
            <label class="form-label">Nombre</label>
            <input type="text" name="nombre" class="form-control" required
                   value="<%= modoEdicion ? h.getNombre() : "" %>">
        </div>

        <div class="mb-3">
            <label class="form-label">Nivel (número)</label>
            <input type="number" name="nivel" class="form-control" required
                   value="<%= modoEdicion ? h.getNivel() : 0 %>">
        </div>

        <div class="d-flex justify-content-between">
            <a href="<%= request.getContextPath() %>/HabilidadController?action=listar" class="btn btn-secondary">Volver</a>
            <button class="btn btn-success" type="submit"><%= modoEdicion ? "Actualizar" : "Guardar" %></button>
        </div>
    </form>
</div>
</body>
</html>

