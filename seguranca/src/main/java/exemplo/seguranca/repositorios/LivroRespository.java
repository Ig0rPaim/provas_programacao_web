package exemplo.seguranca.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exemplo.seguranca.entidades.Livro;

public interface LivroRespository extends JpaRepository<Livro, Long>{
    @Query("select u from livros u where nome like :nome_livro")
    public Livro getbyName(@Param("nome_livro") String nome_livro);

    @Query("insert into livros_usuarios t (t.id_livro, t.id_usuario, t.emprestado) values (:livro_id, :usuario_id, :emprestimo)")
    public void emprestar(@Param("livro_id") Long livro_id, @Param("usuario_id") Long usuario_id, @Param("emprestimo") int emprestimo);

    
    @Query("update livros u set u.quantidade = ?#{qtd} where u.id = ?#{id_livro}")
    public void mudarQuantidade(@Param("qtd") Long qtd, @Param("id_livro") Long id_livro);

    @Query("update livros_usuarios u set u.emprestado = ?#{emprestimo} where u.id_livro = ?#{livro_id} and u.id_usuario = ?#{usuario_id}")
    public void devolver(@Param("emprestimo") int emprestimo, @Param("id_livro") Long id_livro, @Param("usuario_id") Long usuario_id);

}
