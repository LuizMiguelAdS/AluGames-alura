package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main(){
    val gamer = Gamer("Luiz Miguel", "Lmiguelzin@gmail.com")
    println(gamer)
    val gamer2 = Gamer("kaylaine", "kayAurora123@gmail.com", "30/10/2003", "AuroraMorgana")
    println(gamer2)



    gamer.let {
        it.dataNascimento = "30/10/2003"
        it.usuario = "LMiguelHolmes"
    }.also {
       // println(gamer())
    }

}