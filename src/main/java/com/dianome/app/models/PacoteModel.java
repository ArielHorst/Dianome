package com.dianome.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


// Definir como uma entidade
@Entity
// Definir o nome da tabela
@Table(name ="TB_PACOTE")

// Criar a classe PacoteModel e implementar a interface Serialzable

public class PacoteModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

// Informar um Id
    @Id
// Gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

// Definindo o relacionamento entre classes

  // Relação Entregador-Pacote
    @ManyToOne
    // Não gerar uma tabela intermediária "Entregador_Pacote"
    @JoinColumn(name = "entregador_id", nullable = false)
    private EntregadorModel entregadorModel;

  // Relação Pacote-Reclamação
    @OneToMany(mappedBy = "pacoteModel", cascade = CascadeType.REMOVE)
    //Não gerar uma tabela intermediária "Entregador_Pacote"
    private List <ReclamacaoModel> reclamacaoModel;

// Definir as restrições das colunas na base de dados
    @Column(nullable = false, unique = true)
    private String codigoRastreamento;
    @Column(nullable = false)
    @Convert(converter = StatusEnum.Mapeador.class)
    private StatusEnum status;
    @Column(nullable = false)
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataRecebimento;

    @Column
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataEntrega;


    // Construtor padrão para o Hibernate. Esse construtor não será usado diretamente.
    // Logo,adotou-se a anotação "Deprecated"
    @Deprecated
    public PacoteModel() {
    }

    // Construtores
    public PacoteModel(EntregadorModel entregadorModel, List<ReclamacaoModel> reclamacaoModel,
                       String codigoRastreamento, StatusEnum status, LocalDateTime dataRecebimento,
                       LocalDateTime dataEntrega) {
        this.entregadorModel = entregadorModel;
        this.reclamacaoModel = reclamacaoModel;
        this.codigoRastreamento = codigoRastreamento;
        this.status = status;
        this.dataRecebimento = dataRecebimento;
        this.dataEntrega = dataEntrega;
    }

    public PacoteModel(EntregadorModel entregadorModel,
                       String codigoRastreamento, StatusEnum status,
                       LocalDateTime dataRecebimento, LocalDateTime dataEntrega) {
        this.entregadorModel = entregadorModel;
        this.codigoRastreamento = codigoRastreamento;
        this.status = status;
        this.dataRecebimento = dataRecebimento;
        this.dataEntrega = dataEntrega;
    }



    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}





