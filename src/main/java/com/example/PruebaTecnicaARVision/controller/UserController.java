package com.example.PruebaTecnicaARVision.controller;

import com.example.PruebaTecnicaARVision.model.Usuario;
import com.example.PruebaTecnicaARVision.model.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Clase Controlador para el mapeo del CRUD
 */
@Controller
@RequestMapping("/crud")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Método para crear la vista donde se listan los usuarios de la Base de Datos
     * @param model donde se recogen los atributos
     * @return la vista "/crud/lista" a la que navegar
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findUsers(Model model) {
        List<Usuario> usuarios = userServiceImpl.findAll();
        model.addAttribute("titulo", "Usuarios");
        model.addAttribute("usuarios", usuarios);
        return "crud/lista";
    }

    /**
     * Método para crear la vista con un formulario para un nuevo usuario
     * @param model donde se recogen los atributos
     * @return la vista "/crud/nuevo" a la que navegar
     */
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "crud/nuevo";
    }

    /**
     * Método que guarda un usuario en la BD y devuelve la vista "/crud/creado" si no hay error. En caso contrario devuelve la vista "/crud/lista"
     * @param usuario a guardar
     * @param bindingResult para la validación de datos
     * @param model donde se recogen los atributos
     * @return la vista "/crud/lista" a la que navegar en caso de error
     * @return la vista "/crud/creado" a la que navegar en caso de OK
     */
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crear(@Valid Usuario usuario,
                        BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "/crud/lista";
        } else{
            userServiceImpl.saveUser(usuario);
            model.addAttribute("usuario", usuario);
            return "/crud/creado";
        }
    }

    /**
     * Método que devuelve la vista "/crud/creado" donde se muestra el usuario añadido
     * @param usuario que pasamos en el POST del formulario
     * @return la vista "/crud/creado"
     */
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("usuario") Usuario usuario){
        return "/crud/creado";
    }

    /**
     * Método para borrar un usuario y devolver la vista "crud/borrado"
     * @param id del usuario pasado por URL con el GET
     * @param model que recoge el usuario
     * @return la vista "crud/borrado"
     */
    @RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable("id") Long id, Model model){
        userServiceImpl.deleteUser(id);
        model.addAttribute("usuarios", userServiceImpl.findAll());
        return "crud/borrado";
    }
    /**
     * Método para enviar un usuario y devolver la vista "crud/borrado"
     * @param id del usuario pasado por URL con el GET
     * @param model que recoge el usuario
     * @return la vista "crud/editar"
     */
    @RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable("id") Long id, Model model){
        model.addAttribute("usuario", userServiceImpl.findById(id));
        return "crud/editar";
    }

    /**
     * Método que actualiza un usuario y devuelve la vista "crud/actualizado" si ha ido bien. En caso contrario devuelve la vista "crud/lista"
     * @param usuario a actualizar
     * @param bindingResult para validación de datos
     * @param model que recoge el usuario
     * @return "crud/lista" si han habido errores
     * @return "crud/actualizado" si ha ido bien
     */
    @RequestMapping(value="/actualizar", method=RequestMethod.POST)
    public String actualizar(@Valid Usuario usuario, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("usuarios", userServiceImpl.findAll());
            return "crud/lista";
        }
        Usuario user = userServiceImpl.findById(usuario.getId());
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEdad(usuario.getEdad());
        userServiceImpl.saveUser(user);
        model.addAttribute("usuario", user);
        return "crud/actualizado";
    }
}
