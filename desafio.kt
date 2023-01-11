enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL}

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun listaMatriculados() {
        for(usuario in inscritos) {
            println("${usuario.nome} esta na formacao $nome")
        }
    }
    
    fun listaConteudos() {
        for(conteudo in conteudos) {
            println("${conteudo.nome} com duracao de ${conteudo.duracao} horas")
        }
    }
}

fun main() {

   val usuario1 = Usuario("Fulano da Silva")
   val usuario2 = Usuario("Ciclano da Silva")
   val usuario3 = Usuario("Beltrano da Silva")
   val usuario4 = Usuario("Oltrando da Silva")
   val usuario5 = Usuario("Velano da Silva")

   val curso1 = ConteudoEducacional("Curso de Kotlin")
   val curso2 = ConteudoEducacional("Curso de Java")
   val curso3 = ConteudoEducacional("Curso de Android")
   
   val curso4 = ConteudoEducacional("Curso de Javascript")
   val curso5 = ConteudoEducacional("Curso de HTML")
   val curso6 = ConteudoEducacional("Curso de CSS")
   
   val conteudos1 = listOf(curso1, curso2, curso3)
   val conteudos2 = listOf(curso4, curso5, curso6)
   val conteudos3 = listOf(curso1, curso2, curso3, curso4, curso5, curso6)
   
   val formacao1 = Formacao("Desenvolvimento de Aplicativos", Nivel.BASICO, conteudos1)
   val formacao2 = Formacao("Desenvolvimento de Websites", Nivel.INTERMEDIARIO, conteudos2)
   val formacao3 = Formacao("Desenvolvimento de Aplicativos e Websites", Nivel.DIFICIL, conteudos3)
   
   formacao1.matricular(usuario1)
   formacao1.matricular(usuario2)
   formacao1.matricular(usuario3)
   
   formacao2.matricular(usuario3)
   formacao2.matricular(usuario5)
  
   formacao3.matricular(usuario4)
   
   println("Listando usuarios...")
   formacao1.listaMatriculados()
   println()
   formacao2.listaMatriculados()
   println()
   formacao3.listaMatriculados()
   println()
   println("Listando conteudos...")
   
   println("Primeira formacao...")   
   formacao1.listaConteudos()
   println("Segunda formacao...")   
   formacao2.listaConteudos()
   println("Terceira formacao...")   
   formacao3.listaConteudos()
}
