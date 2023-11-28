package com.dianome.app.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum StatusEnum {
    ESTOQUE("estoque"),
    TRANSITO("transito"),
    ENTREGUE("entregue");

    private String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Converter(autoApply = true)
    public static class Mapeador implements AttributeConverter
            <StatusEnum, String> {
        @Override
        public String convertToDatabaseColumn(StatusEnum descricao) {
            return descricao.getDescricao();
        }

        @Override
        public StatusEnum convertToEntityAttribute(String descricao) {
            if (descricao.equals("estoque")){
                return ESTOQUE;
            } else if (descricao.equals("transito")) {
                return TRANSITO;
            } else if (descricao.equals("entregue")) {
                return ENTREGUE;
            } else {
                return null;
            }
        }
    }
}
