package br.edu.ifpr.bsi.projetodisciplina.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
@PrimaryKeyJoinColumn(name = "usuario_id") // FK herdada de Usuario
public class Professor extends Usuario {

    @Column
    private String departamento;

    @Column
    private String formacao;



    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }


}
