package com.agenda.contatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.agenda.contatos.model.Contato;

public class ContatoDao extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "AGENDA.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "tbContato";

    public ContatoDao(Context context) { super(context, NOME_BANCO, null, VERSAO); }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String sql =  "CREATE TABLE "+ TABELA + " ( " +
            " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " nome TEXT, " +
            " email TEXT " +
            ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
    }
    public long incluirContato(Contato c){
        ContentValues values = new ContentValues();
        values.put("Nome", c.getNome());
        values.put("Email", c.getEmail());
        return getWritableDatabase().insert(TABELA, null, values);
    }
}
