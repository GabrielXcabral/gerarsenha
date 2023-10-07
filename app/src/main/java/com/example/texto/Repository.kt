package com.example.texto

class Repository {
    private val armazenarsenhas = mutableListOf<String>();

    fun adicionarsenhas(senha: String) {
        armazenarsenhas.add(senha);
    }

    fun getSenhas(): List<String>{
        return  armazenarsenhas.toList();
    }
}