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
            val posicaopreenchida = mutableListOf<Int>();


            for (i in 0 until tamanho){
                val indexdonumero = random.nextInt(caracteresdasenha.length);
                senha.append(caracteresdasenha[indexdonumero])
            }

            if(temLetraMaiuscula){
                var indexondevai: Int;
                do{
                    indexondevai = random.nextInt(tamanho);
                }while (posicaopreenchida.contains(indexondevai));

                senha.setCharAt(indexondevai, letramaiuscula[random.nextInt(letramaiuscula.length)]);
                posicaopreenchida.add(indexondevai);
            }

            if(temNumero){
                var indexondevai: Int;
                do{
                    indexondevai = random.nextInt(tamanho);
                }while (posicaopreenchida.contains(indexondevai));

                senha.setCharAt(indexondevai, numero[random.nextInt(numero.length)]);
                posicaopreenchida.add(indexondevai);
            }

            if(temCaracter){
                var indexondevai: Int;
                do{
                    indexondevai = random.nextInt(tamanho);
                }while (posicaopreenchida.contains(indexondevai));

                senha.setCharAt(indexondevai, caracter[random.nextInt(caracter.length)]);

            }

            return senha.toString();
        }


    }
}