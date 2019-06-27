package com.example.anotacoes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anotacoes.R
import com.example.anotacoes.data.model.Usuario
import com.example.anotacoes.utils.LocalDbImplement
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.email
import org.jetbrains.anko.toast

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        salvar_cadastro.setOnClickListener {

            val resultado = validar()
            requestLogin(resultado)
        }

        cancelar_cadastro.setOnClickListener {
            //Corta a tela atual
            finish()

        }
    }

    private fun validar(): Boolean {

        if(senha_login.length()<4){
           toast("A senha deve ter pelo menos 8 digítos")
            return false
        }

        if(!(senha_login.text.toString().equals(confirmar_senha.text.toString()))){
            toast("As senhas devem corresponder")
            return false
        }





        if (nick.text.toString().isEmpty()) {
            nick.error = "Campo obrigatorio";
            nick.requestFocus()
            return false
        }

        if (nome.text.toString().isEmpty()) {
            nome.error = "Campo obrigatorio";
            nome.requestFocus()
            return false
        }
        if (email_login.text.toString().isEmpty()) {
            email_login.error = "Campo obrigatorio";
            email_login.requestFocus()
            return false
        }

        return true
    }

    fun requestLogin(login: Boolean){
 if(login) {
    var usuarios: List<Usuario> = listOf()
    //Get List
    if (LocalDbImplement<Usuario>(this@CadastroActivity).getList(Usuario::class.java, "usuarios") != null) {
        usuarios = LocalDbImplement<Usuario>(this@CadastroActivity).getList(Usuario::class.java, "usuarios")!!
    }
    val usuariosList: ArrayList<Usuario> = ArrayList(usuarios)

    val usuario = Usuario()
    usuario.nick = nick.text.toString()
    usuario.nome = nome.text.toString()
    usuario.email = email_login.text.toString()
    usuario.senha = senha_login.text.toString()

    usuariosList.add(usuario)

    //Save List
    LocalDbImplement<Usuario>(this@CadastroActivity).saveList(usuariosList, Usuario::class.java, "usuarios")

    toast("Usuário cadastro com sucesso!")
    //Corta a tela atual
    finish()
}

    }


}
