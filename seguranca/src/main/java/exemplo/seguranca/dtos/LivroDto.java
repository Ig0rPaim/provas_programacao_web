package exemplo.seguranca.dtos;

import exemplo.seguranca.entidades.Livro;

public record LivroDto(
    Long id,
    String nome,
    String autor,
    String sinopse,
    Long quantidade
) {

    public LivroDto(Livro livro){
        this(livro.getId(), livro.getNome(), livro.getAutor(), livro.getSinopse(), livro.getQuantidade());
    }
}
