package com.example.gps.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.gps.dbHelper.ConexaoSQLite;
import com.example.gps.model.ModelCEP;
import com.example.gps.model.ModelEndereco;

import java.util.ArrayList;
import java.util.List;

public class DaoEndereco {

    private ConexaoSQLite conexaoSQLite;

    public DaoEndereco(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarEndereco(ModelEndereco modelEndereco) {

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();
        try {


            ContentValues values = new ContentValues();
            values.put("nome", modelEndereco.getNomeLocal());
            values.put("cep", modelEndereco.getModelCEP().getCep());
            values.put("rua", modelEndereco.getModelCEP().getLogradouro());
            values.put("bairro", modelEndereco.getModelCEP().getBairro());
            values.put("cidade", modelEndereco.getModelCEP().getLocalidade());
            values.put("estado", modelEndereco.getModelCEP().getUf());
            values.put("pais", modelEndereco.getPais());

            long idEndereco = db.insert("tbl_locais", null, values);

            return idEndereco;
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (db != null) {
                db.close();
                ;

            }
        }
        return 0;

    }

    public List<ModelEndereco> getListaDeLocais() {
        List<ModelEndereco> listaModelEndereco = new ArrayList<ModelEndereco>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String sql = "SELECT * FROM tbl_locais";

        try {
            db = this.conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(sql, null);
            ModelEndereco acessoTemporario = null;
            ModelCEP modelCEPTemporario = null;
            if (cursor.moveToFirst()) {
                //Coloquei uma String com o Texto para facilitar a impressao no layout
                do {
                    acessoTemporario = new ModelEndereco();
                    modelCEPTemporario = new ModelCEP();
                    acessoTemporario.setIdModelEndereco(cursor.getInt(0));
                    acessoTemporario.setNomeLocal(cursor.getString(1));
                    modelCEPTemporario.setCep(cursor.getString(2));
                    modelCEPTemporario.setLogradouro(cursor.getString(3));
                    modelCEPTemporario.setBairro(cursor.getString(4));
                    modelCEPTemporario.setLocalidade(cursor.getString(5));
                    modelCEPTemporario.setUf(cursor.getString(6));
                    acessoTemporario.setPais(cursor.getString(7));

                    acessoTemporario.setModelCEP(modelCEPTemporario);

                    listaModelEndereco.add(acessoTemporario);

                } while (cursor.moveToNext());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }

        return listaModelEndereco;
    }


}
