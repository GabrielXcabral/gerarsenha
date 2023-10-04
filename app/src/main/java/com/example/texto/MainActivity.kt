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

    var contador = 1;
    private val armanezartextos = mutableListOf<String>();
    private lateinit var listview: ListView;
    private  lateinit var adapter: ArrayAdapter<String>;
    private lateinit var botao: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao = findViewById(R.id.buttonNext);
        listview = findViewById(R.id.listView);
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, armanezartextos);
        listview.adapter = adapter;

        botao.setOnClickListener(){
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