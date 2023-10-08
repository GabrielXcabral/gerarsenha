package com.example.texto

data class Senha(private val descricao: String, private val senha: String) {

    fun getDescricao(): String{
        return descricao;
    }

    fun getSenha(): String{
        return senha;
    }


}