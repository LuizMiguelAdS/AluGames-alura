package br.com.alura.alugames.servicos

import com.google.gson.Gson
import org.example.br.com.alura.alugames.modelo.InfoJogo
import org.example.br.com.alura.alugames.modelo.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*

class ConsumoApi {

    val leitura = Scanner(System.`in`)
    val listaDeJogos: MutableList<Jogo?> = mutableListOf<Jogo?>()



    fun consumirShark(busca:String){

            val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

            // Criar o cliente HTTP
            val client: HttpClient = HttpClient.newHttpClient()

            // Criar a solicitação HTTP
            val request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build()

            // try {
            //     // Enviar a solicitação e obter a resposta
            //     val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString())

            //     // Verificar o status da resposta
            //     if (response.statusCode() == 200) {
            //         val json = response.body()
            //         println(json)

            //         //val meuJogo = Jogo("Batman: Arkham Asylum Game of the Year Edition","https:\\/\\/shared.akamai.steamstatic.com\\/store_item_assets\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1702934705")
            //         //val meuJogo2 = Jogo("Batman: Arkham City Game of the Year Edition","https:\\/\\/shared.akamai.steamstatic.com\\/store_item_assets\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1702934705")

            //         //println(meuJogo2)
            //         val gson = Gson()
            //         val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

            //         val meuJogo = Jogo(meuInfoJogo.info.titulo, meuInfoJogo.info.capa)

            //         println(meuJogo)


            //     } else {
            //         println("Erro: Recebido código de status ${response.statusCode()}")
            //         println("Corpo da resposta: ${response.body()}")
            //     }

            // } catch (e: Exception) {
            //     println("Erro ao enviar a solicitação: ${e.message}")
            // }

            var meuJogo: Jogo? = null
            val resultado = runCatching {
                // Enviar a solicitação e obter a resposta
                val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString())

                // Verificar o status da resposta
                if (response.statusCode() == 200) {
                    val json = response.body()
                    println(json)

                    //val meuJogo = Jogo("Batman: Arkham Asylum Game of the Year Edition","https:\\/\\/shared.akamai.steamstatic.com\\/store_item_assets\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1702934705")
                    //val meuJogo2 = Jogo("Batman: Arkham City Game of the Year Edition","https:\\/\\/shared.akamai.steamstatic.com\\/store_item_assets\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1702934705")

                    //println(meuJogo2)
                    val gson = Gson()
                    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

                    meuJogo = Jogo(meuInfoJogo.info.titulo, meuInfoJogo.info.capa)

                    println(meuJogo)

                } else {
                    println("Erro: Recebido código de status ${response.statusCode()}")
                    println("Corpo da resposta: ${response.body()}")
                }
            }
        resultado.onFailure { println("Jogo inesistente tente outo id") }

        resultado.onSuccess{
            println("deseja adicionar uma descrição personalizada S/N")
            val opcao = leitura.nextLine();
            if (opcao.equals("S" ,true)){
                val descricao = leitura.nextLine()
                meuJogo?.descricao = descricao
            }else{
                meuJogo?.descricao = meuJogo?.titulo.toString()
            }
            listaDeJogos.add(meuJogo)
        }
        }

        fun consumirSharkExibirListaJogos() {
            println(listaDeJogos)
        }
}