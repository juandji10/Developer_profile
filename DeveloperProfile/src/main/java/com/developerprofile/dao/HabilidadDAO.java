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
        Document doc = new Document("habilidad", habilidad.getHabilidad())
                    .append("nivel", habilidad.getNivel());
        collection.insertOne(doc);
    }

    // Leer
    public List<Habilidad> listarHabilidades() {
        List<Habilidad> habilidades = new ArrayList<>();
        MongoDatabase db = MongoConfig.getDatabase();
        System.out.println("Total docs en la colección: " + collection.countDocuments());
        System.out.println("DB actual: " + db.getName());
        System.out.println("Colección: " + collection.getNamespace());
        for (Document doc : collection.find()) {
            String nivelTexto = doc.getString("nivel");

            int nivelNum = 0;
            try {
                nivelNum = Integer.parseInt(nivelTexto);
            } catch (NumberFormatException e) {
                nivelNum = 1;
            }
            String nivelConvertido;

            if (nivelNum <= 2) {
                nivelConvertido = "Básico";
            } else if (nivelNum == 3) {
                nivelConvertido = "Intermedio";
            } else {
                nivelConvertido = "Avanzado";
            }
            System.out.println("Leyendo -> " + doc.toJson());
            Habilidad h = new Habilidad(
                doc.getObjectId("_id").toString(),
                nivelConvertido,
                doc.getString("habilidad")
            );

        habilidades.add(h);
        }
        return habilidades;
    }

    // Actualizar
    public void editarHabilidad(String id, String nuevoNombre) {
        ObjectId objectId = new ObjectId(id);
        collection.updateOne(
            Filters.eq("_id", objectId),
            new Document("$set", new Document("habilidad", nuevoNombre))
        );
    }

    // Eliminar
    public void eliminarHabilidad(String id) {
        ObjectId objectId = new ObjectId(id);
        collection.deleteOne(Filters.eq("_id", objectId));
    }
}



