package okhttp;
import Helper.contactHelper;

import com.google.gson.Gson;
import dto.AutoresponsDTO;
import dto.ErrorDto;
import dto.authRequestDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests implements contactHelper{

    public static final MediaType Json = MediaType.get("application/json; charset=utf-8");


    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();


    @Test()
    public void LoginPosit() throws IOException {
        authRequestDTO requestDTO = authRequestDTO.builder()
                .username("a@a1.ru")
                .password("DJS@sda1").build();

        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO), Json);

        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();


        Response response = okHttpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            AutoresponsDTO responsDTO = gson.fromJson(response.body().string(), AutoresponsDTO.class);
            Assert.assertEquals(TOKEN,responsDTO.getToken());
            System.out.println(responsDTO.getToken());
            System.out.println("Response code is "+response.code());
            Assert.assertTrue(response.isSuccessful());
        } else
        {
            System.out.println("Response code is "+response.code());
            ErrorDto errorDto=gson.fromJson(response.body().string(), ErrorDto.class);

             System.out.println(errorDto.getStatus()+" "+errorDto.getError()+" "+errorDto.getMessage());
            Assert.assertTrue(response.isSuccessful());

        }

    }

    public static class RegistrationTests {







    }
}
