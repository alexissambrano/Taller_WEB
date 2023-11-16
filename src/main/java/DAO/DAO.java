/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author alons
 */
import java.util.List;

public interface DAO<T> {
    // Métodos CRUD (Create, Read, Update, Delete)

    // Crear un nuevo objeto
    void agregar(T objeto);

    // Obtener un objeto por su ID
    T obtenerPorId(int id);

    // Obtener todos los objetos de la entidad
    List<T> obtenerTodos();

    // Actualizar un objeto
    void actualizar(T objeto);

    // Eliminar un objeto por su ID
    void eliminar(int id);
}
