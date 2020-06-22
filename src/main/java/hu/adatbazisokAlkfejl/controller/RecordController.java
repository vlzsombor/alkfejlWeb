package hu.adatbazisokAlkfejl.controller;


import hu.adatbazisokAlkfejl.dao.Record;
import hu.adatbazisokAlkfejl.dao.RecordsDaoImp;
import hu.adatbazisokAlkfejl.model.SqlRow2;

import java.io.File;
import java.util.List;

public class RecordController {

    private Record dao;
    private static RecordController single_instance = null;
    private File file;


    private RecordController() {
        dao = new RecordsDaoImp(file);
    }

    public static RecordController getInstance(){
        if(single_instance == null){
            single_instance = new RecordController();
        }
        return single_instance;
    }

    public List<SqlRow2> getRecord(String tableName) {
        return dao.getRecords(tableName);
    }
    public List<String> getTables() {
        return dao.getTables();
    }
    public boolean editColumn(String tableName,String newTableName){ return dao.editColumn(tableName,newTableName); }
    public String exportCode(String tableName){ return dao.exportCode(tableName);}
    public List<SqlRow2> executeQuery(String query){ return dao.executeQuery(query); }
}
