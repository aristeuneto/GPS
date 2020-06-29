package com.example.gps.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gps.DAO.DaoEndereco;
import com.example.gps.R;
import com.example.gps.dbHelper.ConexaoSQLite;
import com.example.gps.model.ModelCEP;
import com.example.gps.model.ModelEndereco;
import com.example.gps.util.HttpServiceCEP;

import java.util.concurrent.ExecutionException;

public class CadastrarEnderecoActivity extends AppCompatActivity {

    private EditText edtNomeLocal;
    private EditText edtRua;
    private EditText edtCEP;
    private Button btnBuscarCEP;
    private EditText edtBairro;
    private EditText edtCidade;
    private EditText edtEstado;
    private EditText edtPais;
    private Button btnSalvar;
    private ModelCEP modelCEP;
    private ModelEndereco modelEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_endereco);

        edtNomeLocal = (EditText) findViewById(R.id.edtNomeLocal);
        edtRua = (EditText) findViewById(R.id.edtRua);
        edtCEP = (EditText) findViewById(R.id.edtCEP);
        btnBuscarCEP = (Button) findViewById(R.id.btnBuscar);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
        edtCidade = (EditText) findViewById(R.id.edtCidade);
        edtEstado = (EditText) findViewById(R.id.edtEstado);
        edtPais = (EditText) findViewById(R.id.edtPais);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnBuscarCEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtCEP.getText().toString().isEmpty() == false) {

                    try {
                        modelCEP = new HttpServiceCEP(edtCEP.getText().toString()).execute().get();

                        edtRua.setText(modelCEP.getLogradouro());
                        edtBairro.setText(modelCEP.getBairro());
                        edtCidade.setText(modelCEP.getLocalidade());
                        edtEstado.setText(modelCEP.getUf());

                    } catch (ExecutionException e) {
                        Toast.makeText(CadastrarEnderecoActivity.this, "Insira um CEP válido!", Toast.LENGTH_LONG).show();
                        //   e.printStackTrace();
                    } catch (InterruptedException e) {
                        Toast.makeText(CadastrarEnderecoActivity.this, "Insira um CEP válido!", Toast.LENGTH_LONG).show();
                        //   e.printStackTrace();
                    }
                } else {
                    Toast.makeText(CadastrarEnderecoActivity.this, "Insira o CEP!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoEndereco daoEndereco = new DaoEndereco(ConexaoSQLite.getInstance(CadastrarEnderecoActivity.this));
                modelEndereco = getDadosDoFormulario();

                if (modelEndereco != null) {
                    daoEndereco.salvarEndereco(modelEndereco);
                    Toast.makeText(CadastrarEnderecoActivity.this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CadastrarEnderecoActivity.this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    public ModelEndereco getDadosDoFormulario() {
        modelEndereco = new ModelEndereco();
        modelCEP = new ModelCEP();


        if (edtNomeLocal.getText().toString().isEmpty() == false) {
            modelEndereco.setNomeLocal(edtNomeLocal.getText().toString());
        } else {
            return null;
        }
        if (edtCEP.getText().toString().isEmpty() == false) {
            modelCEP.setCep(edtCEP.getText().toString());
        }else{
            return null;
        }
        if (edtRua.getText().toString().isEmpty() == false) {
            modelCEP.setLogradouro(edtRua.getText().toString());
        } else {
            return null;
        }
        if (edtBairro.getText().toString().isEmpty() == false) {
            modelCEP.setBairro(edtBairro.getText().toString());
        } else {
            return null;
        }
        if (edtCidade.getText().toString().isEmpty() == false) {
            modelCEP.setLocalidade(edtCidade.getText().toString());
        } else {
            return null;
        }
        if (edtEstado.getText().toString().isEmpty() == false) {
            modelCEP.setUf(edtEstado.getText().toString());
        } else {
            return null;
        }
        if (edtPais.getText().toString().isEmpty() == false) {
            modelEndereco.setPais(edtPais.getText().toString());
        } else {
            return null;
        }
        modelEndereco.setModelCEP(modelCEP);


        return modelEndereco;
    }


}