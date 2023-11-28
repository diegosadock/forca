package br.com.sadock.main

import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite uma palavra para gerar a forca: ")
    val palavra = leitura.nextLine()
    println("A palavra tem ${palavra.length} letras")
    var vidas = 5
    val letrasAdivinhadas = mutableSetOf<Char>()
    val letrasErradas = mutableSetOf<Char>()

    while (vidas > 0) {
        val caracteres = palavra.toCharArray()
        println("Digite uma letra para verificar se existe: ")
        val letra = leitura.nextLine()[0]

        if(letra in caracteres) {
            letrasAdivinhadas.add(letra)
            println("Letras adivinhadas até agora: $letrasAdivinhadas")
            val indices = mutableListOf<Int>()
            palavra.forEachIndexed { index, char ->
                if (char == letra) {
                    indices.add(index + 1)
                }
            }
            println("Acertou! A letra digitada está na posição $indices")
        } else {
            println("A palavra não tem essa letra")
            letrasErradas.add(letra)
            println("Letras erradas até o momento: $letrasErradas")
            vidas--
            println("Vidas: $vidas")
        }

        if (palavra.all { it in letrasAdivinhadas }) {
            println("Você acertou todas as letras!")
            break
        }




    }

    println("A palavra era $palavra")

}