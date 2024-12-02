package org.example.br.com.alura.alugames.modelo

data class InfoJogo(val info: Jogo) {
    override fun toString(): String {
        return info.toString()
    }
}