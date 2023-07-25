package okhttp;

import com.google.gson.Gson;
import dto.ContactDTO;
import dto.ContactListDTO;
import dto.authRequestDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAllContacts {
    public static final MediaType Json = MediaType.get("application/json; charset=utf-8");


    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();
String tokern ="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYUBhMS5ydSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNjkwOTA3NDI2LCJpYXQiOjE2OTAzMDc0MjZ9.hWyCo6sCRyI9YNp6UDlKqobcEVpKy6-Jzn50R5_h-gw";

    @Test()
    public void getAllContactsPostitive() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                .addHeader("Authorization", tokern).build();
        Response response = okHttpClient.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        ContactListDTO contacts=gson.fromJson(response.body().string(), ContactListDTO.class);

        for(ContactDTO contactDTO:contacts.getContacts()){
            System.out.println(contactDTO.getId());
            System.out.println("+++++++++++++++++++++");
            System.out.println(contactDTO.getName());
            System.out.println("+++++++++++++++++++++");
            System.out.println(contactDTO.getPhone());
        }

    }
    }
