package Connection;


import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;

public class Db_Connection {

    static  Connection connection = null; 
    public static void connect(){
        
       String message = "";
       try {
            String connectionURL = "jdbc:mysql://localhost/ITECH6401";
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection(connectionURL, "root", "");
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }catch(Exception ex){
                out.println(ex);
            } 
    }
    
    public  static Connection connection(){
        return connection;
    }
    
    
}
