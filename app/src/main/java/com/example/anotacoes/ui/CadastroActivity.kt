package com.example.anotacoes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anotacoes.R
import com.example.anotacoes.data.model.Usuario
import com.example.anotacoes.utils.LocalDbImplement
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        salvar_cadastro.setOnClickListener {

            var usuarios: List<Usuario> = listOf()
            if(LocalDbImplement<Usuario>(this@CadastroActivity).getList(Usuario::class.java, "usuarios") != null){
                usuarios = LocalDbImplement<Usuario>(this@CadastroActivity).getList(Usuario::class.java, "usuarios")!!
            }
            val usuariosList: ArrayList<Usuario> = ArrayList(usuarios)

            val usuario = Usuario()
            usuario.nick = nick.text.toString()
            usuario.nome = nome.text.toString()
            usuario.email = email_login.text.toString()
            usuario.senha = senha_login.text.toString()

            usuariosList.add(usuario)

            LocalDbImplement<Usuario>(this@CadastroActivity).saveList(usuariosList, Usuario::class.java, "usuarios")

            toast("Usuário cadastro com sucesso!")
            finish()
        }

        cancelar_cadastro.setOnClickListener {
            finish()
        }
    }
}
