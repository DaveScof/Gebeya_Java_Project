package com.gebeya.training.java.db;

import com.gebeya.training.java.base.Base;

import java.sql.*;

/**
 * Created by mativo on 22/11/2016.
 *
 * Manages Database Connection
 *
 * TODO: Add more functions to handle creation of tables.
 */

public class SQLConnection extends Base {
    private static String url = "jdbc:sqlite:db/gebeya_java.db";
    private Connection conn;

    public SQLConnection() {
        connect();
    }

    public Connection connect() {
        Connection conn = null;

        /* Initiate connection */
        try {
            conn = DriverManager.getConnection(url);

            println(SQLConnection.class, "Database Connection: Connection was successful.");
            return conn;
        }catch (SQLException ex){

            /* Connection has Failed */
            println(SQLConnection.class, "Database Connection: Connection Failed. :" + ex.getMessage());

        }finally {
            /* Close the Database Connection */
            try {
                conn.close();
            } catch (SQLException e) {
                println(SQLConnection.class, e.getMessage());
            }
        }

        return null;
    }

    /**
     * Close a SQL Statement object
     * @param stmt {@link Statement} to close.
     */
    private void closeConnection(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new Table.
     *
     * @param sql SQL Statement
     * @return boolean TRUE if the Table is created
     */
    public boolean createTable(String sql) {
        if(conn == null) connect();

        if(conn != null) {
            try {
                Statement stmt = conn.createStatement();
                boolean is_created =  stmt.execute(sql);
                closeConnection(stmt);

                return is_created;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else return false;
    }

    /**
     * Insert a new record into a table
     *
     * @param initialValues {@link ContentValues} A map of the columns and their values
     * @param table The TABLE to insert
     * @return TRUE if the record was inserted, FALSE otherwise.
     */
    public boolean insert(ContentValues initialValues, String table) {
        if(conn == null) connect();

        if(conn != null) {
        /* Compute the Insert SQL Statement */
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT");
            sql.append(" INTO ");
            sql.append(table);
            sql.append('(');

            Object[] bindArgs = null;
            int size = (initialValues != null && initialValues.size() > 0)
                    ? initialValues.size() : 0;
            if (size > 0) {
                bindArgs = new Object[size];
                int i = 0;
                for (String colName : initialValues.keySet()) {
                    sql.append((i > 0) ? "," : "");
                    sql.append(colName);
                    bindArgs[i++] = initialValues.get(colName);
                }
                sql.append(')');
                sql.append(" VALUES (");
                for (i = 0; i < size; i++) {
                    sql.append((i > 0) ? ",?" : "?");
                }
            }

            sql.append(')');

            println("Insert: " + table + ": " + sql.toString());

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                int num_changed = pstmt.executeUpdate();

                /* Close the connection */
                closeConnection(pstmt);

                return num_changed > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /**
     * Run a query against the database.
     * @param sql The SQL Statement
     * @return {@link ResultSet} The results of the query, or {@null} if there was no result.
     */
    public ResultSet rawQuery(String sql) {
        if(conn == null) connect();

        if(conn != null) {
            Statement stmt;
            try {
                stmt = conn.createStatement();
                return stmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
