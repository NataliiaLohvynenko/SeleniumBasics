package jSonJava;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

public class jSonToJava {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

       // forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/business?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "lohvynen", "Kosta0505");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from CUSTOMERINFO\n" +
                "where Location = 'Asia';");
        List<CustomerDetails> courseName = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        Gson gson = new Gson();
        String jsonString;

        while (rs.next()) {

            CustomerDetails customerDetails = new CustomerDetails();
            customerDetails.setCourseName(rs.getString("courseName"));
            customerDetails.setPurchasedDete(rs.getString("purchaseDate"));
            customerDetails.setAmount(rs.getInt("Amount"));
            customerDetails.setLocation(rs.getString("Location"));
            courseName.add(customerDetails);
        }

        ObjectMapper om = new ObjectMapper();
        for (CustomerDetails customerdetails : courseName
        ) {

            jsonArray.add(jsonString = gson.toJson(customerdetails));
            //om.writeValue(new File("src\\main\\resources\\customerInfo_"+customerdetails.getCourseName()+".json"), customerdetails);

        }


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);
        String myjsonString = StringEscapeUtils.unescapeJava(jsonObject.toJSONString());
        String formated = myjsonString.replace("\"{", "{").replace("}\"", "}");


        System.out.println(formated);


        //om.writeValue(new File("src\\main\\resources\\customerInfo.json"), jsonObject);

        try (FileWriter file = new FileWriter("src\\main\\resources\\customerInfo.json")) {
            file.write(formated);

        }
    }

}
