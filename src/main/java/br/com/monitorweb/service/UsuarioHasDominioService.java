package br.com.monitorweb.service;

import br.com.monitorweb.entity.Usuario;
import br.com.monitorweb.entity.UsuarioHasDominio;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import br.com.monitorweb.repository.UsuarioHasDominioRepository;
import br.com.monitorweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/usuariohasdominio")
    public class UsuarioHasDominioService {

    /* Repositorio responsavel*/
    @Autowired
    private UsuarioHasDominioRepository usuarioHasDominioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<UsuarioHasDominio> buscar(){
        return usuarioHasDominioRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        Usuario usuarioDaBusca = usuarioRepository.findOne(id);

        if(usuarioDaBusca == null){
            throw new SqlInexistenteRuntimeException("Usuario não localizado.", null);
        }

        return usuarioHasDominioRepository.findByUsuario(usuarioDaBusca);
    }
}
