package com.knoxcorporation.knxbank.Databases;

import android.content.Context;
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

    }
}
