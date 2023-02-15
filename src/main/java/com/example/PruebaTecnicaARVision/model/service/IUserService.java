package com.example.PruebaTecnicaARVision.model.service;

import com.example.PruebaTecnicaARVision.model.Usuario;

import java.util.List;

/**
 * Interfaz que provee los métodos para realizar un CRUD.
 */
public interface IUserService {
    /**
     * Método que devuelve todos los usuarios de la Base de Datos
     * @return List de Usuario
     */
    public List<Usuario> findAll();

    /**
     * Método que devuelve un usuario pasando como parámetro el id
     * @param id identificador del usuario en la Base de Datos
     * @return objeto Usuario
     */
    public Usuario findById(Long id);

    /**
     * Método que añade un usuario pasado como parámetro
     * @param usuario objeto Usuario a guardar
     * @return objeto Usuario guardado
     */
    public Usuario saveUser(Usuario usuario);

    /**
     * Método que borra de la Base de Datos un usuario pasando como parámetro el id
     * @param id identificador del usuario en la Base de Datos
     */
    public  void deleteUser(Long id);

    /**
     * Método que actualiza en la Base de Datos un usuario pasado como parámetro
     * @param usuario objeto Usuario a actualizar
     * @return objeto Usuario actualizado
     */
    public Usuario updateUser(Usuario usuario);

    /**
     * Método que busca un usuario en la Base de Datos pasando como parámetro el id
     * @param id identificador del usuario en la Base de Datos
     * @return boolean en función de si lo encuentra
     */
    public boolean existById(Long id);
}
