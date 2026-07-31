package com.jorge.aprendendo_spring.business;

import com.jorge.aprendendo_spring.infrastructure.entity.Usuario;
import com.jorge.aprendendo_spring.infrastructure.exceptions.ConflictExecptions;
import com.jorge.aprendendo_spring.infrastructure.exceptions.ResourceNotFoundException;
import com.jorge.aprendendo_spring.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvaUsuario(Usuario usuario) {
        emailExiste(usuario.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public void emailExiste(String email){
        boolean existe = verificaEmailExistente(email);
        if(existe){
            throw new ConflictExecptions("Email já cadastrado: " + email);
        }
    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscaUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado: " + email));
    }

    public void deletarUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }
}