package com.example.texto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView

class CriarSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_senha)

        val tamanhodasenhacomseekbar = findViewById<SeekBar>(R.id.seekBar);
        val texto = findViewById<TextView>(R.id.textView3);
        val bntgerarsenha = findViewById<Button>(R.id.buttoncriarsenha);
        val checkboxletramaiuscula = findViewById<CheckBox>(R.id.checkBoxLetraMaiuscula);
        val checkboxcaracter = findViewById<CheckBox>(R.id.checkBoxCaracter);
        val checkboxnumero = findViewById<CheckBox>(R.id.checkBoxNumero);

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
                texto.text = "Tamanho da senha: $tamanhodasenha"
            }

        })

        bntgerarsenha.setOnClickListener(){
            val letramaiuscula = checkboxletramaiuscula.isChecked;
            val numero = checkboxnumero.isChecked;
            val caracter = checkboxcaracter.isChecked;
            val tamanho = tamanhodasenha;

            val senha = GerarSenha.criarsenha(letramaiuscula, numero, caracter, tamanho);

        }


    }
}
