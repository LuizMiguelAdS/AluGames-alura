package br.com.alura.alugames.modelo

import java.util.Scanner
import kotlin.random.Random as Random

data class Gamer(var nome:String, var email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }
    private var idInterno:String? = null
        get(){
            return idInterno
        }
        private set


    init {
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome esta em branco")
        }
        this.email = validarEmail();
    }


    constructor(nome: String, email: String, dataNascimente:String, usuario:String) :
            this(nome, email){
                this.dataNascimento = dataNascimente
                this.usuario = usuario
                criarIdInterno()
            }

    override fun toString(): String {
        return "Game(nome= '$nome', Email='$email', DataNascimento='$dataNascimento')"
    }

    fun criarIdInterno(){
        val numero = Random.nextInt(900000)
        val tag = String.format("%04d", numero)
        idInterno = nome+tag
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}\$")
        if (regex.matches(email)){
            return email;
        }else{
            throw IllegalArgumentException("Email invalido")
        }
    }

    companion object{
        fun criarGamer(leitura: Scanner):Gamer{
            println("boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome")
            val  nome =leitura.nextLine()
            println("Digite seu email")
            val  email =leitura.nextLine()
            println("Deseja completar seu cadastro com usuario e data de nascimento?")
            val opcao =leitura.nextLine()
            if (opcao.equals("s",true)){
                println("Digite seu data de nascimento")
                val  dtNasc =leitura.nextLine()
                println("Digite seu usuario")
                val  usuario =leitura.nextLine()
                return Gamer(nome, email, dtNasc, usuario);

            }else{
                return Gamer(nome, email)
            }


        }
    }


}
