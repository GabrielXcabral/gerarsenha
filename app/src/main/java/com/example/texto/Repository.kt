package com.example.texto

class Repository {
    private val armazenarsenhas = mutableListOf<Senha>();

    fun adicionarsenhas(senha: Senha) {
        armazenarsenhas.add(senha);
    }

    fun getSenhas(): List<Senha>{
        return  armazenarsenhas.toList();
    }

    fun getSenha(descricao: String): String{

        val objsenha = armazenarsenhas.find { it.getDescricao() == descricao };
        if (objsenha != null) {
            return objsenha.getSenha();
        };
        return "";
    }

    fun atualizarSenha(descricao: String, novasenha: String){
        val index = armazenarsenhas.indexOfFirst { it.getDescricao() == descricao };
        if (index != -1){
            val senhaAtualizada = armazenarsenhas[index].copy(senha = novasenha)
            armazenarsenhas[index] = senhaAtualizada;
        }
    }

    fun remover (descricao: String){
        val index = armazenarsenhas.indexOfFirst { it.getDescricao() == descricao };
        if(index != -1){
            armazenarsenhas.removeAt(index);
        }
    }
}