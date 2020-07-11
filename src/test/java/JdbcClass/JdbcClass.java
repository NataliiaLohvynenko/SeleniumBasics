package JdbcClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcClass {

    public static void main(String[] args) throws SQLException {

           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "lohvynen","Kosta0505");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from actor");

        List<String> name = new ArrayList<>();
        while(rs.next()){

            name.add(rs.getString("first_name"));

        }
        System.out.println(name);

    }

}
