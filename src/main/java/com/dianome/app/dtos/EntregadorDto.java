package com.dianome.app.dtos;

import com.dianome.app.models.EntregadorModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class EntregadorDto {

    @NotBlank
    @Size(max=70)
    private String nome;

    @NotBlank
    @Size(max=3)
    private String idade;

    @NotBlank
    @Size(max = 20)
    private String cnhRegistro;

    @NotBlank
    @Size(max = 20)
    private String cnhRenach;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 11)
    private String numeroCelular;

    @NotBlank
    @Size(max = 11)
    private String carteiraTrabalho;

    public EntregadorModel transformToModel(){
        return new EntregadorModel(this.getNome(),this.getIdade(),this.getCnhRegistro(),
            this.getCnhRenach(), this.getCpf(), this.getNumeroCelular(),this.getCarteiraTrabalho());
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCnhRegistro() {
        return cnhRegistro;
    }

    public void setCnhRegistro(String cnhRegistro) {
        this.cnhRegistro = cnhRegistro;
    }

    public String getCnhRenach() {
        return cnhRenach;
    }

    public void setCnhRenach(String cnhRenach) {
        this.cnhRenach = cnhRenach;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCarteiraTrabalho() {
        return carteiraTrabalho;
    }

    public void setCarteiraTrabalho(String carteiraTrabalho) {
        this.carteiraTrabalho = carteiraTrabalho;
    }
}
