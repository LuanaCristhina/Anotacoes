package com.example.anotacoes.data.model

/*Data classe que salva o objeto Usuarios e é instanciada na main
    atravez da biblioteca (import com.example.arquivo.data.model.Usuario)para atribuição dos valores*/

data class Usuario(
    var nick: String? ="",
    var nome: String? = "",
    var email: String? = "",
    var senha: String? = ""
)