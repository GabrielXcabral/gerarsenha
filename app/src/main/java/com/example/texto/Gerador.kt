package com.example.texto

import java.lang.StringBuilder

class Gerador {

    companion object{
        fun criarsenha (temLetraMaiuscula: Boolean, temNumero: Boolean, temCaracter: Boolean, tamanho: Int): String{
            val letra = "abcdefghijklmnopqrstuvwxyz";
            val letramaiuscula = if (temLetraMaiuscula) "ABCDEFGHIJKLMNOPQRSTUVWXYZ" else "";
            val numero = if (temNumero) "0123456789" else "";
            val caracter = if(temCaracter) "!@#%^&*()_-+={}[]|:;'<>,.?/~¢£€¥¤§°©®™µπ∆∞≠±√•×÷" else "";


            val caracteresdasenha = buildString {
                append(letra);
                append(letramaiuscula);
                append(numero);
                append(caracter);
            }

            val senha = StringBuilder();
            val random = java.util.Random();

            for (i in 0 until tamanho){
                val indexdonumero = random.nextInt(caracteresdasenha.length);
                senha.append(caracteresdasenha[indexdonumero])
            }

            return senha.toString();
        }


    }
}