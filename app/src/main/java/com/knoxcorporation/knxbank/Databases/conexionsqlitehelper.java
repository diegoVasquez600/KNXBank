package com.knoxcorporation.knxbank.Databases;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.knoxcorporation.knxbank.utilidades.utilidades;

public class conexionsqlitehelper extends SQLiteOpenHelper {


    public conexionsqlitehelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase knxcBankdb) {
        knxcBankdb.execSQL(utilidades.CREAR_TABLACLIENTE);
        knxcBankdb.execSQL(utilidades.CREAR_TABLACUENTA);
        knxcBankdb.execSQL(utilidades.CREAR_TABLATRANSACCION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase knxcBankdb, int i, int i1) {
        knxcBankdb.execSQL("DROP TABLE IF EXISTS cliente");
        knxcBankdb.execSQL("DROP TABLE IF EXISTS cuenta");
        knxcBankdb.execSQL("DROP TABLE IF EXISTS transaccion");
        onCreate(knxcBankdb);
    }

    public Cursor Consultarusuario(String user, String pass)throws SQLException {
        Cursor mcursor=null;

            mcursor=this.getReadableDatabase().query(utilidades.TABLA_CLIENTE,new String[]{utilidades.CAMPO_ID,utilidades.CAMPO_DNI,utilidades.CAMPO_NOMBRE,utilidades.CAMPO_APELLIDOS,
                    utilidades.CAMPO_EDAD,utilidades.CAMPO_CLAVE,utilidades.CAMPO_EMAIL},utilidades.CAMPO_DNI+"like'"+user+"'"+utilidades.CAMPO_CLAVE+"like'"+pass+"'",
                    null,null,null,null);

        return mcursor;


    }
}
