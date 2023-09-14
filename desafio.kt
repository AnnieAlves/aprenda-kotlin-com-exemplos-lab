enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
         if(!inscritos.contains(usuario)){
             inscritos.add(usuario)
             println("O(a) aluno(a) ${usuario.nome} foi matriculado(a) com sucesso na formação $nome ")
         }else{
             println("O(a) aluno(a) ${usuario.nome} já está matriculado(a) no formação $nome")
         }
    }

    fun totalHoras(): Int{
        return conteudos.sumOf { it.duracao }
    }

    fun listarAlunos(): String {
        return inscritos.joinToString(separator = "\n") {it.nome }
    }

}



fun main() {
    val ana = Usuario("Ana")
    val mel = Usuario("Mel")
    val luna = Usuario("Luna")
    val paulo = Usuario("Paulo")
    val marcelo = Usuario("Marcelo")
    val leticia = Usuario("Leticia")


    val conteudoKotlin1 = ConteudoEducacional("Introdução à Linguagem Kotlin", 4)
    val conteudoKotlin2 = ConteudoEducacional("Funções de Kotlin", 4)
    val conteudoKotlin3 = ConteudoEducacional("Orientação a Objetos com Kotlin", 4)
    val conteudoKotlin4 = ConteudoEducacional("Desafios e Projetos com Kotlin", 6)




    val conteudoProgramacao1 = ConteudoEducacional("Lógica de programação", 2)
    val conteudopProgramacao2 = ConteudoEducacional("Algoritmos e exercícios", 4)

    val conteudoFront1 = ConteudoEducacional("HTML e CSS", 3)
    val conteudoFront2 = ConteudoEducacional("Introdução ao JavaScript", 3)
    val conteudoFront3 = ConteudoEducacional("Projeto completo CSS, HTML e JavaScript", 8)

    val FormacaoIniciante =
            Formacao(
                    "Introdução à programação",
                    listOf(conteudoProgramacao1, conteudopProgramacao2),
                    Nivel.BASICO
                    )

    val FormacaoFront =
            Formacao(
                    "Desenvolvimento Front-End",
                    listOf(conteudoFront1, conteudoFront2, conteudoFront3),
                    Nivel.BASICO
                    )

    val FormacaoKotlin =
            Formacao("Linguagem Kotlin",
                    listOf(conteudoKotlin1, conteudoKotlin2, conteudoKotlin3, conteudoKotlin4),
                    Nivel.INTERMEDIARIO
                    )


    FormacaoIniciante.matricular(leticia)
    FormacaoIniciante.matricular(paulo)
    FormacaoIniciante.matricular(marcelo)

    FormacaoFront.matricular(marcelo)
    FormacaoFront.matricular(luna)
    FormacaoIniciante.matricular(marcelo)

    FormacaoKotlin.matricular(ana)
    FormacaoKotlin.matricular(mel)

    val listaFormacoes = listOf(FormacaoIniciante, FormacaoFront, FormacaoKotlin)

    listaFormacoes.forEach {
        println("\nA formação ${it.nome}, de nível ${it.nivel} tem duração de ${it.totalHoras()} horas. Alunos cadastrados: \n${it.listarAlunos()}")
    }










}
