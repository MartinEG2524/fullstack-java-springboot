package com.retotecnico.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.retotecnico.api.Service.RandomUsuarioService;
import com.retotecnico.api.Model.Usuario;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private RandomUsuarioService randomUsuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return randomUsuarioService.obtenerUsuarios();
    }
}