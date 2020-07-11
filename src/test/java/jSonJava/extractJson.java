package jSonJava;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class extractJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper o = new ObjectMapper();
        CustomerDetailsApium c =o.readValue(new File("src\\main\\resources\\customerInfo1.json"),CustomerDetailsApium.class);
        System.out.println(c.getCourseName());
    }
}
