package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    protected static final String NAME_DB = "banco.db";
    protected static final int VERSION = 1;

    // TABELA DOS USUARIOS
    protected static final String TABLE_USER = "users";
    protected static final String ID_USER = "_id_user";
    protected static final String USER = "user";
    protected static final String PASSWORD = "password";

    // TABELA DAS PESSOAS
    protected static final String TABLE_PERSON = "persons";
    protected static final String ID_PERSON ="_id_person";
    protected static final String NAME = "nome";
    protected static final String HOME_ADRESS = "home_adress";
    protected static final String WORK_ADRESS = "work_adress";
    protected static final String EMERGENCY_CONTACT1 = "emergency_contact1";
    protected static final String EMERGENCY_CONTACT2 = "emergency_contact2";
    protected static final String EMERGENCY_CONTACT3 = "emergency_contact3";
    protected static final String HEALTHCARE_PROGRAM = "health_care";
    protected static final String AGE = "age";
    public DbHelper(Context context){
        super(context,NAME_DB,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlScripts.getTableUSer());
        db.execSQL(SqlScripts.getTablePerson());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PERSON);

        onCreate(db);
    }


}
