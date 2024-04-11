package exemplo.seguranca.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exemplo.seguranca.dtos.EmprestimoDto;
import exemplo.seguranca.entidades.Livro;
import exemplo.seguranca.repositorios.LivroRespository;

@Service
public class LivroService {

    @Autowired
    LivroRespository livroRespository;


    public ResponseEntity<List<Livro>> listar(){
        try{
            var livros = livroRespository.findAll();
            if (livros.equals(null)){
                 return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(livros);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Livro> pesquisar(String nome){
        try{
            var livro = livroRespository.getbyName(nome);
            if(livro.equals(null))
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok().body(livro);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Livro> detalhar(Long id){
        try{
            var livro = livroRespository.findById(id);
            if(!livro.isPresent())
                return ResponseEntity.notFound().build(); 
            return ResponseEntity.ok().body(livro.get());
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


    // public ResponseEntity emprestar(EmprestimoDto emprestimo){
    //     try{
    //         var livro = livroRespository.findById(emprestimo.id_livro());
    //         if(!livro.isPresent())
    //             return ResponseEntity.notFound().build(); 
    //         var qtd = livro.get().getQuantidade() - 1;
    //         // livroRespository.mudarQuantidade(qtd, emprestimo.id_livro());
    //         livroRespository.emprestar(emprestimo.id_livro(), emprestimo.id_usuario(), 1);
    //         return ResponseEntity.ok().build();
    //     }catch(Exception e){
    //         return ResponseEntity.badRequest().build();
    //     }
    // }


    // public ResponseEntity devolver(Long id_livro, Long id_usuario){
    //     try{
    //         var livro = livroRespository.findById(id_livro);
    //         if(!livro.isPresent())
    //             return ResponseEntity.notFound().build(); 
    //         var qtd = livro.get().getQuantidade() + 1;
    //         // livroRespository.mudarQuantidade(qtd, id_livro);
    //         livroRespository.devolver(0, id_livro, id_usuario);
    //         return ResponseEntity.ok().build();
    //     }catch(Exception e){
    //         return ResponseEntity.badRequest().build();
    //     }
    // }
}
