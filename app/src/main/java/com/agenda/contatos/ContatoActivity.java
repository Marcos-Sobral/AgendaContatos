package com.agenda.contatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agenda.contatos.dao.ContatoDao;
import com.agenda.contatos.model.Contato;

public class ContatoActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtEmail;
    Button btnSalvar;
    Contato contato;
    ContatoDao contatoDao;
    long retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        btnSalvar = findViewById(R.id.btnSalvar);

        contatoDao = new ContatoDao(ContatoActivity.this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contato = new Contato();
                contato.setNome(edtNome.getText().toString());
                contato.setEmail(edtEmail.getText().toString());

                retorno = contatoDao.incluirContato(contato);

                if (retorno == -1){
                    Toast.makeText(getApplicationContext(), "Erro ao Salvar Contato",Toast.LENGTH_LONG) .show();
                }else{
                    Toast.makeText(getApplicationContext(), "Contato Salvo !",Toast.LENGTH_LONG) .show();
                }
            }
        });
    }
}