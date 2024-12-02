package org.example.br.com.alura.alugames.modelo

import com.google.gson.annotations.SerializedName

data class Jogo (   @SerializedName("title") val titulo:String,
               @SerializedName("thumb") val capa:String){

    var descricao = ""

    override fun toString(): String {
        return "Meu jogo: \n"+"Titulo: $titulo;\n Capa: $capa\n Descrição: $descricao"
    }
}