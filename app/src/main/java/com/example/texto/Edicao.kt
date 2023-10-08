package com.example.texto

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class Edicao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicao)

        val repository = (applicationContext as MyApp).repository

        val descricaosenha = intent.getStringExtra("descricao");

        val tamanhodasenhacomseekbar = findViewById<SeekBar>(R.id.edicaoseekBar);
        val texto = findViewById<TextView>(R.id.textView3);
        val nomedasenha = findViewById<EditText>(R.id.descricaoedit);
        val bnteditar = findViewById<Button>(R.id.buttonalterar);
        val bntexluir = findViewById<Button>(R.id.buttonexcluir)
        val checkboxletramaiuscula = findViewById<CheckBox>(R.id.checkBoxLetraMaiuscula);
        val checkboxcaracter = findViewById<CheckBox>(R.id.checkBoxCaracter);
        val checkboxnumero = findViewById<CheckBox>(R.id.checkBoxNumero);
        val exibirsenha = findViewById<TextView>(R.id.exibirsenha);
        val bntvoltar = findViewById<Button>(R.id.bntvoltar)

        val senha = descricaosenha?.let { repository.getSenha(descricaosenha) };
        exibirsenha.text = senha;

        nomedasenha.setText(descricaosenha);

        var tamanhodasenha = tamanhodasenhacomseekbar.progress + 1;

        tamanhodasenhacomseekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Não é necessário fazer nada aqui se você não deseja atualizar o valor em tempo real
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Não é necessário fazer nada aqui
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Quando o usuário soltar a barra, atualize o valor
                tamanhodasenha = tamanhodasenhacomseekbar.progress + 1;
                texto.text = "Tamanho da senha: $tamanhodasenha";
            }

        })

        bnteditar.setOnClickListener(){
            val letramaiuscula = checkboxletramaiuscula.isChecked;
            val numero = checkboxnumero.isChecked;
            val caracter = checkboxcaracter.isChecked;
            val tamanho = tamanhodasenha;

            val senha = Gerador.criarsenha(letramaiuscula, numero, caracter, tamanho);
            val descricao = nomedasenha.text.toString();

            repository.atualizarSenha(descricao, senha);

            val intent = Intent(this, MainActivity::class.java);
            //intent.putExtra("senha", senha);
            /*setResult(Activity.RESULT_OK, intent);
            finish();*/
            startActivity(intent);

        }

        bntexluir.setOnClickListener(){
            val descricao = nomedasenha.text.toString();
            repository.remover(descricao);

            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

        bntvoltar.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }
}