package com.developerprofile.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.developerprofile.model.Habilidad;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class HabilidadDAO {

    private final MongoCollection<Document> collection;

    public HabilidadDAO() {
        MongoDatabase db = MongoConfig.getDatabase();
        this.collection = db.getCollection("habilidades");
    }

    // Crear
    public void agregarHabilidad(Habilidad habilidad) {
        Document doc = new Document("nombre", habilidad.getNombre())
                .append("nivel", habilidad.getNivel());
        collection.insertOne(doc);
    }

    // obtener por id
    public Habilidad obtenerPorId(String id) {
        Document doc = collection.find(Filters.eq("_id", new ObjectId(id))).first();
        if (doc == null)
            return null;
        Integer nivelDoc = doc.getInteger("nivel");
        int nivel = (nivelDoc != null) ? nivelDoc : 0;
        return new Habilidad(nivel, doc.getObjectId("_id").toString(), doc.getString("nombre"));
    }

    // editar con nivel
    public void editarHabilidad(String id, String nuevoNombre, int nuevoNivel) {
        ObjectId objectId = new ObjectId(id);
        Document updates = new Document("$set", new Document("nombre", nuevoNombre).append("nivel", nuevoNivel));
        collection.updateOne(Filters.eq("_id", objectId), updates);
    }

    // Leer
    public List<Habilidad> listarHabilidades() {
        List<Habilidad> habilidades = new ArrayList<>();

        for (Document doc : collection.find()) {
            Habilidad h = new Habilidad(
                    doc.getInteger("nivel"),
                    doc.getObjectId("_id").toString(),
                    doc.getString("nombre"));
            habilidades.add(h);
        }

        return habilidades;
    }

    // Actualizar
    public void editarHabilidad(String id, String nuevoNombre) {
        ObjectId objectId = new ObjectId(id);
        collection.updateOne(
                Filters.eq("_id", objectId),
                new Document("$set", new Document("nombre", nuevoNombre)));
    }

    // Eliminar
    public void eliminarHabilidad(String id) {
        ObjectId objectId = new ObjectId(id);
        collection.deleteOne(Filters.eq("_id", objectId));
    }
}
