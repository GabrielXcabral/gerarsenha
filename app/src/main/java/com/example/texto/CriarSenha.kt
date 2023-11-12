package com.example.texto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import com.example.texto.banco.BancoHelper


class CriarSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_senha)

        val repository = (applicationContext as MyApp).repository
        val bancoHelper = BancoHelper(this);

        val tamanhodasenhacomseekbar = findViewById<SeekBar>(R.id.seekBar);
        val texto = findViewById<TextView>(R.id.textView3);
        val nomedasenha = findViewById<EditText>(R.id.descricaoedit)
        val bntgerarsenha = findViewById<Button>(R.id.buttoncriarsenha);
        val checkboxletramaiuscula = findViewById<CheckBox>(R.id.checkBoxLetraMaiuscula);
        val checkboxcaracter = findViewById<CheckBox>(R.id.checkBoxCaracter);
        val checkboxnumero = findViewById<CheckBox>(R.id.checkBoxNumero);
        val bntvoltar = findViewById<Button>(R.id.bntvoltar);

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

        bntgerarsenha.setOnClickListener(){
            val letramaiuscula = checkboxletramaiuscula.isChecked;
            val numero = checkboxnumero.isChecked;
            val caracter = checkboxcaracter.isChecked;
            val tamanho = tamanhodasenha;

            val senha = Gerador.criarsenha(letramaiuscula, numero, caracter, tamanho);
            val descricao = nomedasenha.text.toString();

            val objsenhasenha = Senha(descricao, senha);


            //repository.adicionarsenhas(objsenhasenha);
            bancoHelper.insert(objsenhasenha)

            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);

        }

        bntvoltar.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }


    }
}
