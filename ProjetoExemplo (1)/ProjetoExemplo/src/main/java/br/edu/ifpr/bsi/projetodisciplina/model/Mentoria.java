package br.edu.ifpr.bsi.projetodisciplina.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_mentoria")
public class Mentoria extends GenericModel {

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @Column
    private String certificado;

    @ManyToMany
    @JoinTable(
            name = "mentoria_alunos",
            joinColumns = @JoinColumn(name = "mentoria_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunosParticipantes;

    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunosParticipantes() {
        return alunosParticipantes;
    }

    public void setAlunosParticipantes(List<Aluno> alunosParticipantes) {
        this.alunosParticipantes = alunosParticipantes;
    }
}
