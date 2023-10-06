package com.example.texto

class GerarSenha {
    companion object{
        fun criarsenha (temLetraMaiuscula: Boolean, temNumero: Boolean, temCaracter: Boolean, tamanho: Int){
            val letra = "abcdefghijklmnopqrstuvwxyz";
            val letramaiuscula = if (temLetraMaiuscula) "ABCDEFGHIJKLMNOPQRSTUVWXYZ" else "";
            val numero = if (temNumero) "0123456789" else "";
            val caracter = if(temCaracter) "!@#%^&*()_-+={}[]|:;'<>,.?/~¢£€¥¤§°©®™µπ∆∞≠±√•×÷" else "";


            val montarsenha = buildString {
                append(letra);
                append(letramaiuscula);
                append(numero);
                append(caracter);
            }





        }
    }
}