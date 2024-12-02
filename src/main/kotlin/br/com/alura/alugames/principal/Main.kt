package org.example.br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.Gson
import org.example.br.com.alura.alugames.modelo.InfoJogo
import org.example.br.com.alura.alugames.modelo.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    val consumoApi = ConsumoApi();

    var busca: String?
    do {
        println("digite o codigo do jogo")
        busca = leitura.nextLine()

       val resultado = consumoApi.consumirShark(busca)


    }while (busca != "0")

    val resultadoFinal = consumoApi.consumirSharkExibirListaJogos()


}
