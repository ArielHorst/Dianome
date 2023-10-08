package com.dianome.app.entregador;

public class Entregador {
    private Long id;
    private String nome;
    private String cpf;
    private String cnh;
    private String veiculo;
    private String placaVeiculo;

    public Entregador() {
    }

    public Entregador(Long id,
                      String nome,
                      String cpf,
                      String cnh,
                      String veiculo,
                      String placaVeiculo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.placaVeiculo = placaVeiculo;
    }

    public Entregador(String nome,
                      String cpf,
                      String cnh,
                      String veiculo,
                      String placaVeiculo) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.placaVeiculo = placaVeiculo;
    }

    public Long getId() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnh='" + cnh + '\'' +
                ", veiculo='" + veiculo + '\'' +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                '}';
    }
}
