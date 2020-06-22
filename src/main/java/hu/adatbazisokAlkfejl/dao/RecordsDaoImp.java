package hu.adatbazisokAlkfejl.dao;

import hu.adatbazisokAlkfejl.model.SqlRow2;
import hu.adatbazisokAlkfejl.util.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RecordsDaoImp implements Record {

    public static File getDbFilePath() {
        return dbFilePath;
    }

    public void setDbFilePath(File dbFilePath) {
        RecordsDaoImp.dbFilePath = dbFilePath;
    }

    private static File dbFilePath = new File("../sample.db");

    public RecordsDaoImp(File file) {
        dbFilePath = file;
    }

    public RecordsDaoImp() {
    }


    public List<String> getTables() {
        List<String> result = new ArrayList<>();

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/yourdb");
            Connection conn = ds.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(Utils.SQL.SELECT_TABLES);

            while (rs.next()) {
                result.add(rs.getString(1));
            }

            ctx.close();
            conn.close();
            ctx.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<SqlRow2> getRecords(String tableName) {
        List<SqlRow2> result = new ArrayList<>();

        SqlRow2.setSelected_table_name(tableName);


        try {

            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/yourdb");
            Connection conn = ds.getConnection();
            Statement st = conn.createStatement();
            SqlRow2.retrieveSetColumnsAndPrimaryKeyName(st,tableName);

            ResultSet rs = st.executeQuery(Utils.SQL.GET_RECORDS_SQLIT(tableName));

            while (rs.next()) {
                SqlRow2 sqlRow2 = new SqlRow2();

                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    String field = rs.getString(i + 1);
                    sqlRow2.getValues().add(field);
                    StringProperty str = new SimpleStringProperty(field);
                    sqlRow2.getValuesProperty().add(str);
                }
                result.add(sqlRow2);
            }
            ctx.close();
            conn.close();
            ctx.close();
        } catch (Exception e) {

        }

        return result;
    }

    @Override
    public boolean editColumn(String columnName, String newColumnName) {
        String query = "ALTER TABLE " + SqlRow2.getSelected_table_name() + " RENAME " + columnName + " TO " + newColumnName + ";";
        try  {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/yourdb");
            Connection conn = ds.getConnection();
            Statement st = conn.createStatement();


            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();

            ctx.close();
            conn.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String exportCode(String tableName) {
        try  {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/yourdb");
            Connection conn = ds.getConnection();
            Statement st = conn.createStatement();


            ResultSet rs = st.executeQuery(Utils.SQL.EXPORT_SQL(tableName));
            while (rs.next()) {
                return rs.getString(1);
            }
            ctx.close();
            conn.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<SqlRow2> executeQuery(String query) {


        List<SqlRow2> result = new ArrayList<>();

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/yourdb");
            Connection conn = ds.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            List<String> columnsName = new ArrayList<>();


            for (int i = 1; i <= columnCount; i++) {
                String name = rsmd.getColumnName(i);
                columnsName.add(name);
            }
            SqlRow2.getQueryColumnsName().clear();
            SqlRow2.getQueryColumnsName().addAll(columnsName);


            while (rs.next()) {
                SqlRow2 sqlRow2 = new SqlRow2();
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    String field = rs.getString(i + 1);
                    sqlRow2.getValues().add(field);
                    StringProperty str = new SimpleStringProperty(field);
                    sqlRow2.getValuesProperty().add(str);
                }
                result.add(sqlRow2);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 101) {
                //Utils.showDialog(Alert.AlertType.INFORMATION,"Nincs eredmény","Nincs megjeleníthető eredmény a querynek");
                return null;
            }
            //Utils.showDialog(Alert.AlertType.ERROR,"hiba",e.toString());
            return null;
            //e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return result;
    }

}

