package com.dianome.app.dtos;

import com.dianome.app.models.EntregadorModel;
import com.dianome.app.models.PacoteModel;
import com.dianome.app.models.ReclamacaoModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReclamacaoDto {

    @NotNull
    private PacoteModel pacote;

    @NotBlank
    @Size(max=70)
    private String nomeReclamante;

    @NotBlank
    @Size(max=11)
    private String telefone;

    @NotBlank
    private String descricaoReclamacao;

    @NotBlank
    private String descricaoSolucao;

//    @NotBlank
//    @Size(min = 7)
//    private String codigoRastreamento;


    public ReclamacaoModel transformToModel(){
        return new ReclamacaoModel(this.getPacote(),this.getNomeReclamante(),
                this.getTelefone(),
                this.getDescricaoReclamacao(),
                this.getDescricaoSolucao());
    }


    public PacoteModel getPacote() {
        return pacote;
    }

    public void setPacote(PacoteModel pacote) {
        this.pacote = pacote;
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
