package hu.adatbazisokAlkfejl.dao;

import hu.adatbazisokAlkfejl.model.SqlRow2;

import java.util.List;

public interface Record {

    public List<String> getTables();

    public List<SqlRow2> getRecords(String tableName);

    public boolean editColumn(String columnName,String newColumnName);

    public String exportCode(String tableName);
    public List<SqlRow2> executeQuery(String query);
}