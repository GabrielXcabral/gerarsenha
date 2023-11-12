package com.example.texto.banco

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.texto.Senha

class BancoHelper (context: Context): SQLiteOpenHelper(context, "bd_senhas", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table senha( " +

                "id integer primary key autoincrement, " +
                "descricao text, " +
                "senha text)"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table senha")
        this.onCreate(db)
    }

    fun insert (senha: Senha){
        val bd = writableDatabase;
        val valores = ContentValues().apply{
            put("descricao", senha.getDescricao());
            put("senha", senha.getSenha());
        }
        bd.insert("senha", null, valores);
        bd.close();
    }

    fun getSenhas(): List<Senha> {
        val senhas = mutableListOf<Senha>()
        val bd = readableDatabase
        val cursor: Cursor = bd.rawQuery("SELECT * FROM senha", null)

        val idIndex = cursor.getColumnIndex("id");
        val descricaoIndex = cursor.getColumnIndex("descricao")
        val senhaIndex = cursor.getColumnIndex("senha")

        if(idIndex != -1 && descricaoIndex != -1 && senhaIndex != -1){
            while (cursor.moveToNext()) {
                val id = cursor.getInt(idIndex)
                val descricao = cursor.getString(descricaoIndex)
                val senha = cursor.getString(senhaIndex)

                val senhaObj = Senha(descricao, senha)
                senhas.add(senhaObj)
            }
        }
        cursor.close()
        bd.close()
        return senhas
    }

    fun getSenha (descricao: String): Senha?{
        val db = readableDatabase;
        val cursor: Cursor = db.rawQuery("SELECT * FROM senha WHERE descricao = ?", arrayOf(descricao));

        var senha: Senha? = null;

        val dbdescricao = cursor.getColumnIndex("descricao");
        val dbsenha = cursor.getColumnIndex("senha");

        if(dbdescricao != -1 && dbsenha != -1){
            if(cursor.moveToFirst()){
                val descricaoBD = cursor.getString(dbdescricao);
                val senhaBD = cursor.getString(dbsenha);

                senha = Senha(descricaoBD, senhaBD);
            }
            cursor.close()
            db.close()
            return senha;
        }
        return null
    }

    fun atualizarSenha (descricao: String, novasenha: String) {
        val db = writableDatabase;

        val senhanova = ContentValues().apply {
            put("senha", novasenha)
        }

        val where = "descricao = ?";
        val pwhere = arrayOf(descricao);

        db.update("senha", senhanova, where, pwhere);
    }

    fun remover (descricao: String){
        val db = writableDatabase;

        val where = "descricao = ?";
        val pwhere = arrayOf(descricao);

        db.delete("senha", where, pwhere);
    }



}