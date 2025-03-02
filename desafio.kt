// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
enum class Escolaridade {FUNDAMENTAL, MEDIO, TECNICO, GRADUACAO, POSGRADUACAO}

data class Aluno (
    val nome:String,
    val email:String,
    val escolaridade: Escolaridade
)

data class ConteudoEducacional(
    val nome: String,
    val nivel: Nivel,
    val duracao: Int = 60
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val escolaridade: Escolaridade
){
    val conteudos = mutableListOf<ConteudoEducacional>()

    fun conteudoProgramatico(conteudo : ConteudoEducacional){
        conteudos.add(conteudo)
    }
}

data class Turma(
    val formacao: Formacao
){
    val inscritos = mutableListOf<Aluno>()

    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
    }
}

fun main() {
    val aluno1 = Aluno("John Doe","john.doe@escola.com",Escolaridade.MEDIO)
    val aluno2 = Aluno("Marie Ane","marie01@mail.com", Escolaridade.GRADUACAO)
    val aluno3 = Aluno("Jack Dee","jackie@dee.com",Escolaridade.GRADUACAO)

    val conteudoEducacional1 = ConteudoEducacional(
        "Logica de Programação", Nivel.BASICO,4
    )
    val conteudoEducacional2 = ConteudoEducacional(
        "Pensamento Sistemico", Nivel.BASICO, 4
    )
    val conteudoEducacional3 = ConteudoEducacional(
        "Linguagem de Programacao", Nivel.BASICO, 12
    )
    val conteudoEducacional4 = ConteudoEducacional(
        "Programação Orientada a Objetos", Nivel.INTERMEDIARIO, 4
    )
    val conteudoEducacional5 = ConteudoEducacional(
        "Design Patterns", Nivel.INTERMEDIARIO, 4
    )

    val formacaoProgramador = Formacao(nome = "Programador",
        nivel = Nivel.INTERMEDIARIO,
        escolaridade = Escolaridade.TECNICO
    )

    formacaoProgramador.conteudoProgramatico(conteudoEducacional1)
    formacaoProgramador.conteudoProgramatico(conteudoEducacional2)
    formacaoProgramador.conteudoProgramatico(conteudoEducacional3)
    formacaoProgramador.conteudoProgramatico(conteudoEducacional4)
    formacaoProgramador.conteudoProgramatico(conteudoEducacional5)

    val turma = Turma(formacaoProgramador)
    turma.matricular(aluno1)
    turma.matricular(aluno2)
    turma.matricular(aluno3)

    println("Turma do curso de {${turma.formacao.nome}} de nível {${turma.formacao.nivel}}")
    println("Conteúdo Programático")
    for (conteudo in turma.formacao.conteudos){
        println(" - ${conteudo.toString()}")
    }
    println("\nAlunos matriculados no curso {${turma.formacao.nome}}:")
    for (aluno in turma.inscritos) {
        println(" - $aluno")
    }

}
