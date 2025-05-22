package com.example.cp3_java.DTO;

import jakarta.validation.constraints.*;

public class BrinquedoDTO {

    @NotBlank(message = "O nome do brinquedo é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "O tipo do brinquedo é obrigatório.")
    private String tipo;

    @NotBlank(message = "A classificação do brinquedo é obrigatória.")
    private String classificacao;

    @NotNull(message = "O tamanho do brinquedo é obrigatório.")
    @Positive(message = "O tamanho deve ser maior que zero.")
    private Double tamanho;

    @NotNull(message = "O preço do brinquedo é obrigatório.")
    @Min(value = 1, message = "O preço deve ser no mínimo R$1,00.")
    private Double preco;

    public BrinquedoDTO() {}

    public BrinquedoDTO(String nome, String tipo, String classificacao, Double tamanho, Double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
