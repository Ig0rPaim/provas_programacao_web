package exemplo.seguranca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "livros_usuarios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Livro_Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Livro id_livro;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario id_usuario;
    private int emprestado;
}
