data class Pais(
    var habitantes: Double,
    val taxaCrescimento: Double
) {
    fun crescerPopulacaoAnual() {
        habitantes = habitantes * ((taxaCrescimento*0.01)+1)
    }
}

fun main() {
    val habitantesPaisA = readLine()!!.toDouble()
    val habitantesPaisB = readLine()!!.toDouble()
    val paisA = Pais(habitantesPaisA, taxaCrescimento = 3.0)
    val paisB = Pais(habitantesPaisB, taxaCrescimento = 1.5)

    var quantidadeAnos = 0
    do {
        paisA.crescerPopulacaoAnual()
        paisB.crescerPopulacaoAnual()
        quantidadeAnos++
    } while (paisA.habitantes < paisB.habitantes)

    println("$quantidadeAnos anos")
}