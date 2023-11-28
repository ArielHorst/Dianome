package com.dianome.app.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.UUID;

// Definir como uma entidade
@Entity
// Definir o nome da tabela
@Table(name = "TB_RECLAMACAO")

// Criar a classe ReclamacaoModel e implementar a interface Serialzable
public class ReclamacaoModel implements Serializable {
    private static final long serialVersionUID = 1L;

// Informar um Id
    @Id
// Gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

// Definindo o relacionamento entre classes
    @ManyToOne
    @JoinColumn(name = "pacote_codigoRastreamento", nullable =false)
    private PacoteModel pacoteModel;


// Definir as restrições das colunas na base de dados
    @Column(nullable = false,length =70)
    private String nomeReclamante;
    @Column(nullable = false,length =11)
    private String telefone;
    @Column(nullable = false)
    private String descricaoReclamacao;
    @Column(nullable = false)
    private String descricaoSolucao;

    // Código de Rastreamento (mínimo): 2 Letras + 5 números
//    @Column(nullable = false, unique = true)
//    private String codigoRastreamento;


    // Construtor padrão para o Hibernate. Esse construtor não será usado diretamente.
    // Logo,adotou-se a anotação "Deprecated"
    @Deprecated
    public ReclamacaoModel() {
    }

    // Construtores

    public ReclamacaoModel(PacoteModel pacoteModel,
                           String nomeReclamante, String telefone,
                           String descricaoReclamacao,
                           String descricaoSolucao) {
        this.pacoteModel = pacoteModel;
        this.nomeReclamante = nomeReclamante;
        this.telefone = telefone;
        this.descricaoReclamacao = descricaoReclamacao;
        this.descricaoSolucao = descricaoSolucao;
    }



    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeReclamante() {
        return nomeReclamante;
    }

    public void setNomeReclamante(String nomeReclamante) {
        this.nomeReclamante = nomeReclamante;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricaoReclamacao() {
        return descricaoReclamacao;
    }

    public void setDescricaoReclamacao(String descricaoReclamacao) {
        this.descricaoReclamacao = descricaoReclamacao;
    }

    public String getDescricaoSolucao() {
        return descricaoSolucao;
    }

    public void setDescricaoSolucao(String descricaoSolucao) {
        this.descricaoSolucao = descricaoSolucao;
    }

//    public String getCodigoRastreamento() {
//        return codigoRastreamento;
//    }
//
//    public void setCodigoRastreamento(String codigoRastreamento) {
//        this.codigoRastreamento = codigoRastreamento;
//    }
}
