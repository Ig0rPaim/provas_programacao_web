package exemplo.seguranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.dtos.EmprestimoDto;
import exemplo.seguranca.servicos.LivroService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    
    @Autowired
    LivroService livroService;


    @GetMapping
    public ResponseEntity listar(){
        return livroService.listar();
    }

    // @GetMapping
    // public ResponseEntity pesquisar(String nome){
    //     return livroService.pesquisar(nome);
    // }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        return livroService.detalhar(id);
    }



}
