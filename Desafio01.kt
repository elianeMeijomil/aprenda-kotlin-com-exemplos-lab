fun main() {
    val numeroRomano: String? = readLine()?.uppercase()

    val numerosRomanos = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var resultado:Int = 0
    var valorAnterior:Int = 0


    for (i in numeroRomano!!.indices) {
        val valorAtual = numerosRomanos.getValue(numeroRomano[i])
        if (valorAtual > valorAnterior) {
            resultado += (valorAtual - 2 * valorAnterior) // Ajuste para subtração
        } else {
            resultado += valorAtual
        }
        valorAnterior = valorAtual

    }

    print(resultado)
}