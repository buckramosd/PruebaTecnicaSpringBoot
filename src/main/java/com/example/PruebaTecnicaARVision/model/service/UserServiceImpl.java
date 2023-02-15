package com.example.PruebaTecnicaARVision.model.service;

import com.example.PruebaTecnicaARVision.model.Usuario;
import com.example.PruebaTecnicaARVision.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clase que implementa la interfaz IUserService y desarrolla los métodos para el CRUD.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Método que devuelve todos los usuarios de la Base de Datos
     * @return List de Usuario
     */
    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    /**
     * Método que devuelve un usuario pasando como parámetro el id
     * @param id identificador del usuario en la Base de Datos
     * @return objeto Usuario
     */
    @Override
    public Usuario findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    /**
     * Método que añade un usuario pasado como parámetro
     * @param usuario objeto Usuario a guardar
     * @return objeto Usuario guardado
     */
    @Override
    public Usuario saveUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    /**
     * Método que borra de la Base de Datos un usuario pasando como parámetro el id
     * @param id identificador del usuario en la Base de Datos
     */
    @Override
    public  void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Método que actualiza en la Base de Datos un usuario pasado como parámetro
     * @param usuario objeto Usuario a actualizar
     * @return objeto Usuario actualizado
     */
    @Override
    public Usuario updateUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    /**
     * Método que busca un usuario en la Base de Datos pasando como parámetro el id
     * @param id identificador del usuario en la Base de Datos
     * @return boolean en función de si lo encuentra
     */
    @Override
    public boolean existById(Long id) {
        return  userRepository.existsById(id);
    }

}
