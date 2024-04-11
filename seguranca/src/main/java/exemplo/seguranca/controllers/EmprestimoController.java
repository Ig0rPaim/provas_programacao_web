package exemplo.seguranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.config.SecurityFilter;
import exemplo.seguranca.dtos.EmprestimoDto;
import exemplo.seguranca.servicos.JWTokenService;
import exemplo.seguranca.servicos.LivroService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @Autowired
    LivroService livroService;

    @Autowired
    JWTokenService tokenJWT;

    @Autowired
    SecurityFilter securityFilter;

    @Autowired
    HttpServletRequest request;
    
    // @PostMapping("/emprestimos")
    // @Transactional
    // @Secured("user_admin")
    // public ResponseEntity emprestar(@RequestBody EmprestimoDto emprestimoDto){
    //     return livroService.emprestar(emprestimoDto);
    // }

    // @PutMapping("/emprestimos/{id}")
    // @Transactional
    // @Secured("user_admin")
    // public ResponseEntity devolver(@PathVariable Long idLivro){
    //     var token = securityFilter.recuperarToken(request);
    //     var claimId = tokenJWT.getId(token);
    //     return livroService.devolver(idLivro, idLivro);
    // }
}
