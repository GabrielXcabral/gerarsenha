package com.example.texto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    /*companion object {
        const val REQUEST_CODE_CRIAR_SENHA = 1
    }
*/
    var contador = 1;
    private val armanezarsenha = mutableListOf<String>();
    private lateinit var listview: ListView;
    private  lateinit var adapter: ArrayAdapter<String>;
    private lateinit var botao: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (applicationContext as MyApp).repository
        botao = findViewById(R.id.buttonNext);
        listview = findViewById(R.id.listView);
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, armanezarsenha);
        listview.adapter = adapter;

        val senha = repository.getSenhas();


        if (senha.isNotEmpty()){
            armanezarsenha.addAll(senha);
            adapter.notifyDataSetChanged();
            listview.smoothScrollToPosition(armanezarsenha.size - 1);
        }

        botao.setOnClickListener(){

            /*val intent = Intent(this, CriarSenha::class.java)
            startActivityForResult(intent, REQUEST_CODE_CRIAR_SENHA)*/

            val intent = Intent (this, CriarSenha::class.java);
            startActivity(intent);

            /*val texto = "Texto $contador";
            armanezartextos.add(texto);
            adapter.notifyDataSetChanged();
            listview.smoothScrollToPosition(armanezartextos.size - 1);
            contador++;*/
        }
    }
}