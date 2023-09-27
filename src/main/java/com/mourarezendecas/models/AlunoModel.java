package com.mourarezendecas.models;

public class AlunoModel {
    private String nome;
    private String curso;
    private String matricula;
    private String email;

    public AlunoModel(String nome, String curso, String matricula, String email) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
