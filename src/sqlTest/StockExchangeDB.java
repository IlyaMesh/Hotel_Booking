package sqlTest;

import org.postgresql.shaded.com.ongres.stringprep.StringPrep;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class StockExchangeDB {

    private static final String DB_URL="jbdc:postgresql://127.0.0.1:5432/vertex";
    private static final String USER = "username";
    private static final String PASS = "password";

    private static StockExchangeDB instance;
    private static

    public static StockExchangeDB getInstance(){
        if(instance == null){
            instance = new StockExchangeDB();
        }
        return instance;
    }

    private StockExchangeDB(){
        //methods to connect the db
    }

    private boolean connectDB(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){

        }
    }


}
