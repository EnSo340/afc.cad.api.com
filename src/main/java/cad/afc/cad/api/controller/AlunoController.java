package cad.afc.cad.api.controller;

import cad.afc.cad.api.aluno.Aluno;
import cad.afc.cad.api.aluno.CadastroAluno;
import cad.afc.cad.api.aluno.AlunoRepository;
import cad.afc.cad.api.aluno.DadosCadastroAluno;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public void cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dadosAluno) {
        Aluno aluno = new Aluno(dadosAluno);
        repository.save(aluno);

    }

}