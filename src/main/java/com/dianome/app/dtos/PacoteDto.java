package com.dianome.app.dtos;

import com.dianome.app.models.EntregadorModel;
import com.dianome.app.models.PacoteModel;
import com.dianome.app.models.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;



public class PacoteDto {

    @NotBlank(message = "O código de rastreamento não pode ser vazio.")
    @Size(min = 7)
    //CodigoRastreamento:2 Letras + 5 números
    private String codigoRastreamento;

    @NotNull
    private EntregadorModel entregador;

    @NotNull(message = "O campo status não pode ser vazio." +
            "(valores válidos:ESTOQUE, ENTREGUE, TRANSITO).")
    // 3 opções válidas: Estoque; Trânsito; Entregue.
    //@NotNull e @Null são as únicas anotações de validação padrão para enum..
    //Mas é possivel criar e personalizar uma anotação/validação.
    private StatusEnum status;

    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @PastOrPresent(message = "A data de recebimento não pode ser uma data futura.")
    @NotNull(message = "A data de recebimento precisa ser informada!")
    private LocalDateTime dataRecebimento;

    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @PastOrPresent(message = "A data de recebimento não pode ser uma data futura.")
    private LocalDateTime dataEntrega;

    public PacoteModel transformToModel(){
        return new PacoteModel(this.getEntregador(),this.getCodigoRastreamento(), this.getStatus(),
                this.getDataRecebimento(), this.getDataEntrega());
    }



    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
    }

    public EntregadorModel getEntregador() {return entregador;}

    public void setEntregador(EntregadorModel entregador) {
        this.entregador = entregador;
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
