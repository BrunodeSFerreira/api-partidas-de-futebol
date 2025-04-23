package com.meli.api_futebol.model;

public enum EstadosBrasileiros {

    AC("AC", "Acre", 12),
    AL("AL", "Alagoas", 27),
    AM("AM", "Amazonas", 13),
    AP("AP", "Amapá", 16),
    BA("BA", "Bahia", 29),
    CE("CE", "Ceará", 23),
    DF("DF", "Distrito Federal", 53),
    ES("ES", "Espírito Santo", 32),
    GO("GO", "Goiás", 52),
    MA("MA", "Maranhão", 21),
    MG("MG", "Minas Gerais", 31),
    MS("MS", "Mato Grosso do Sul", 50),
    MT("MT", "Mato Grosso", 51),
    PA("PA", "Pará", 15),
    PB("PB", "Paraíba", 25),
    PE("PE", "Pernambuco", 26),
    PI("PI", "Piauí", 22),
    PR("PR", "Paraná", 41),
    RJ("RJ", "Rio de Janeiro", 33),
    RN("RN", "Rio Grande do Norte", 24),
    RO("RO", "Rondônia", 11),
    RR("RR", "Roraima", 14),
    RS("RS", "Rio Grande do Sul", 43),
    SC("SC", "Santa Catarina", 42),
    SE("SE", "Sergipe", 28),
    SP("SP", "São Paulo", 35),
    TO("TO", "Tocantins", 17);


    private final String sigla;
    private final String nome;
    private final int codigo;

    EstadosBrasileiros(String sigla, String nome, int codigo) {
        this.sigla = sigla;
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }
}
