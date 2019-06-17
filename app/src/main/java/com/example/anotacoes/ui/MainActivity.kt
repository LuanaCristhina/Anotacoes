package com.example.anotacoes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anotacoes.R
import com.example.anotacoes.data.model.Usuario
import com.example.anotacoes.utils.LocalDbImplement
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //BOTÃO DE LOGIN <INICIO>
    //variavel de valor unico com seu nome será igual a um array do tipo class.
    private var pessoas: List<Usuario> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(LocalDbImplement<Usuario>(this@MainActivity).getList(Usuario::class.java, "usuarios") != null){
            pessoas = LocalDbImplement<Usuario>(this@MainActivity).getList(Usuario::class.java, "usuarios")!!
        }

        btnLogin.setOnClickListener {

            var x = 0

            while (x < pessoas.size) {

                if (email.text.toString() == pessoas[x].email && senha.text.toString() == pessoas[x].senha) {
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    break
                }
                if (x == pessoas.size - 1) {
                    Toast.makeText(this, "Senha ou Email invalido", Toast.LENGTH_SHORT).show()
                }
                x++
                }
            }
        //BOTÃO DE LOGIN <FIM>

        //BOTÃO DE CADASTRO <INICIO>

        btnCadastro.setOnClickListener {
            val Intent = Intent(this, CadastroActivity::class.java)
            startActivity(Intent)
        }
        }
    }



