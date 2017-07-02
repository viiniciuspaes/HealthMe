package dao;


import static dao.DbHelper.*;

public class SqlScripts {
    protected static String getTableUSer(){

        StringBuilder userBuilder = new StringBuilder();
        userBuilder.append("CREATE TABLE "+TABLE_USER+" ( ");
        userBuilder.append(ID_USER+" integer primary key aytoincrement, ");
        userBuilder.append(USER+" text not null unique, ");
        userBuilder.append(PASSWORD+" text not null);");
        return userBuilder.toString();
    }
    protected static String getTablePerson(){

        StringBuilder personBuilder = new StringBuilder();
        personBuilder.append("CREATE TABLE "+TABLE_PERSON+" ( ");
        personBuilder.append(ID_PERSON+" integer primary key autoincrement, ");
        personBuilder.append(NAME +" text not null, ");
        personBuilder.append(HOME_ADRESS+" text not null, ");
        personBuilder.append(WORK_ADRESS+" text not null, ");
        personBuilder.append(EMERGENCY_CONTACT1+" text not null, ");
        personBuilder.append(EMERGENCY_CONTACT2+" text not null, ");
        personBuilder.append(EMERGENCY_CONTACT3+" text not null, ");
        personBuilder.append(HEALTHCARE_PROGRAM+" text, ");
        personBuilder.append(AGE+" text");
        return personBuilder.toString();
    }
}
