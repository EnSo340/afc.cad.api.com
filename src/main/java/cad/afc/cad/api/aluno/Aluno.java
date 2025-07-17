package cad.afc.cad.api.aluno;

import cad.afc.cad.api.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "aluno")
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    int anoDeNasc;
    String serieAtual;
    String email;
    String telefone;
    String cpf;

    @Embedded
    private Endereco endereco;

    public Aluno(DadosCadastroAluno dadosAluno){
        this.nome = dadosAluno.nome();
        this.anoDeNasc = dadosAluno.anoDeNasc();
        this.email = dadosAluno.email();
        this.endereco = new Endereco(dadosAluno.endereco());
        this.telefone = dadosAluno.telefone();
        this.serieAtual = dadosAluno.serieAtual();
        this.cpf = dadosAluno.cpf();
    }
}