package br.edu.ifpr.bsi.projetodisciplina.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
@PrimaryKeyJoinColumn(name = "usuario_id") // FK herdada de Usuario
public class Aluno extends Usuario {

    @Column
    private String curso;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Column
    private String ra;

    @Column
    private Integer anoIngresso;

    @Column
    private String turno;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Column
    private String periodo;


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(Integer anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
