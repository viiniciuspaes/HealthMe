package dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import domain.Person;

public class UserDao {
    private SQLiteDatabase db;
    private DbHelper dataBase;


    public UserDao(Context context){
        dataBase = new DbHelper(context);
    }
    public void insertRegister(Person person){
        ContentValues values;
        long output;
        db = dataBase.getWritableDatabase();

        values = new ContentValues();
        values.put(DbHelper.USER, person.getUser().toString());
        values.put(DbHelper.PASSWORD,person.getUser().getPassword());

        db.insert(DbHelper.TABLE_USER, null, values);

        // precisa de algo para avisar se der erro
        values = new ContentValues();
        values.put(DbHelper.NAME,person.getName());
        values.put(DbHelper.HOME_ADRESS, person.getHomeAdress());
        values.put(DbHelper.WORK_ADRESS, person.getWorkAdress());
        values.put(DbHelper.EMERGENCY_CONTACT1, person.getEmergencyContacts()[0].getName());
        values.put(DbHelper.EMERGENCY_CONTACT2, person.getEmergencyContacts()[1].getName());
        values.put(DbHelper.EMERGENCY_CONTACT3, person.getEmergencyContacts()[2].getName());
        values.put(DbHelper.HEALTHCARE_PROGRAM, person.getHealthcareProgram());
        values.put(DbHelper.AGE, person.getAge() );

        db.insert(DbHelper.TABLE_PERSON,null, values);
        db.close();

    }
    public void UpdateRegister(Person person){
        ContentValues values;
        String where;

        db = dataBase.getWritableDatabase();
        where = DbHelper.ID_USER+ "=" +person.getId();

        values = new ContentValues();
        values.put(DbHelper.USER, person.getUser().toString());
        values.put(DbHelper.PASSWORD,person.getUser().getPassword());

        db.update(DbHelper.TABLE_USER, values, where, null);

        // precisa de algo para avisar se der erro

        where = DbHelper.ID_PERSON+ "=" +person.getId();
        values = new ContentValues();
        values.put(DbHelper.NAME,person.getName());
        values.put(DbHelper.HOME_ADRESS, person.getHomeAdress());
        values.put(DbHelper.WORK_ADRESS, person.getWorkAdress());
        values.put(DbHelper.EMERGENCY_CONTACT1, person.getEmergencyContacts()[0].getName());
        values.put(DbHelper.EMERGENCY_CONTACT2, person.getEmergencyContacts()[1].getName());
        values.put(DbHelper.EMERGENCY_CONTACT3, person.getEmergencyContacts()[2].getName());
        values.put(DbHelper.HEALTHCARE_PROGRAM, person.getHealthcareProgram());
        values.put(DbHelper.AGE, person.getAge() );

        db.update(DbHelper.TABLE_PERSON, values, where, null);
        db.close();
    }
}
