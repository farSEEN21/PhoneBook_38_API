package okhttp;

import Helper.contactHelper;
import com.google.gson.Gson;
import dto.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class AddNewContact implements contactHelper {


    String endpoint = "contacts";

    @Test
    public void addContact() throws IOException {
//        RequestBodyContactDTO requestBodyContactDTO = RequestBodyContactDTO.builder().
//                id("dsafdfs")
//                .name("dfsdfsdff")
//                .lastName("dfdsffsdfsdfs")
//                .email("dsfsdf@dsffsd.ru")
//                .phone("32423423234")
//                .address("dsfsdfdsfsdf")
//                .description("sdfwfewf").build();


        System.out.println(createContact());
        RequestBody contactbodyjso = RequestBody.create(gson.toJson(createContact()), Json);


        Request request = new Request.Builder().
                url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                .addHeader("Authorization", TOKEN).post(contactbodyjso).build();
        Response response = okHttpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            AutoresponsDTO responsDTO = gson.fromJson(response.body().string(), AutoresponsDTO.class);
            System.out.println(responsDTO.getToken());
            System.out.println("Response code is " + response.code());
            Assert.assertTrue(response.isSuccessful());
        } else {
            System.out.println("Response code is " + response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
            System.out.println(errorDto.getStatus() + " " + errorDto.getError() + " ");//+errorDto.getMessage());
//            System.out.println(errorDto.getMessage());
            Assert.assertTrue(response.isSuccessful());

        }
//
//        System.out.println(response.isSuccessful());
//        System.out.println(response.code());

    }

    @Test
    public void addNewContactPositive() throws IOException {

        ContactDTO contactDTO = ContactDTO.builder()
                .name("Aq39.")
                .lastName("auth")
                .email("qa38" + i + "@gmail.com")
                .phone("123123123" + i)
                .address("regove")
                .description("St")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(contactDTO), Json);

        Request request = new Request.Builder()
                .url(baseurl + "/" + path + "/" + endpoint)
                .addHeader("Authorization", TOKEN).post(requestBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        ContactResponseDTO contactResponseDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
        Assert.assertTrue(response.isSuccessful());
        String message = contactResponseDTO.getMessage();
        System.out.println(message);
        String id = message.substring(message.lastIndexOf(" ") + 1);
        System.out.println(id);
    }
}
