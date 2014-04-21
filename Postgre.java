import java.sql.*;

public class Postgre {
  public static void main(String[] args) {      
    try {
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver O.K.");
      String url = "jdbc:postgresql://192.168.12.101:5432/aero";
      String user = "michel";
      String passwd = "michel42";
      Connection conn = DriverManager.getConnection(url, user, passwd);
      System.out.println("Connexion effective !");         
         
    } catch (Exception e) {
      e.printStackTrace();
    }      
  }
}