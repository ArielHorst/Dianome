package com.dianome.app.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


// Definir como uma entidade
@Entity
// Definir o nome da tabela
@Table(name="TB_ENTREGADOR")


// Criar a classe EntregadorModel e implementar a interface Serialzable
public class EntregadorModel implements Serializable {
    private static final long serialVersionUID = 1L;

// Informar um Id
// Gerar o id automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

// Definindo o relacionamento entre classes
    @OneToMany(mappedBy = "entregadorModel", cascade = CascadeType.REMOVE)
    private List<PacoteModel> pacoteModel;

// Definir as restrições das colunas na base de dados &
// Atributos (variáveis)
    @Column(nullable = false, length =70)
    private String nome;
    @Column(nullable = false, length =3)
    private String idade;
    @Column(nullable = false, unique = true,length =20)
    private String cnhRegistro;
    @Column(nullable = false, unique = true,length =20)
    private String cnhRenach;
    @Column(nullable = false, unique = true, length =11)
    private String cpf;
    @Column(nullable = false, unique = true, length =11)
    private String numeroCelular;
    @Column(nullable = false, unique = true, length =11)
    private String carteiraTrabalho;
    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    // Construtor padrão para o Hibernate. Esse construtor não será usado diretamente.
    // Logo,adotou-se a anotação "Deprecated"
    @Deprecated
    public EntregadorModel() {
    }


    // Construtores
    public EntregadorModel(List<PacoteModel> pacoteModel, String nome, String idade, String cnhRegistro,
                           String cnhRenach, String cpf, String numeroCelular, String carteiraTrabalho,
                           LocalDateTime dataRegistro) {
        this.pacoteModel = pacoteModel;
        this.nome = nome;
        this.idade = idade;
        this.cnhRegistro = cnhRegistro;
        this.cnhRenach = cnhRenach;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.carteiraTrabalho = carteiraTrabalho;
        this.dataRegistro = dataRegistro;
    }

    public EntregadorModel(String nome,
                           String idade, String cnhRegistro,
                           String cnhRenach, String cpf, String numeroCelular,
                           String carteiraTrabalho) {
        this.nome = nome;
        this.idade = idade;
        this.cnhRegistro = cnhRegistro;
        this.cnhRenach = cnhRenach;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.carteiraTrabalho = carteiraTrabalho;
    }


    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setIdade(String idade){
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

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}

