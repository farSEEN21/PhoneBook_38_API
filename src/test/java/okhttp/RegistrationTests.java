package okhttp;

import Helper.contactHelper;
import com.google.gson.Gson;
import dto.AutoresponsDTO;
import dto.ErrorDto;
import dto.RegistrationDTO;
import dto.authRequestDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import java.io.IOException;

import static org.bouncycastle.crypto.tls.ConnectionEnd.client;

public class RegistrationTests implements contactHelper {

    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();

    @Test
    public void positiveRegistrationTest() throws IOException {
        RegistrationDTO registrationDTO = RegistrationDTO.builder().username(generateRandomEmail()).password(generateRandompsw()).build();
        System.out.println(registrationDTO);


        RequestBody requestBody = RequestBody.create(gson.toJson(registrationDTO), Json);

        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/user/registration/usernamepassword")
                .post(requestBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            AutoresponsDTO responsDTO = gson.fromJson(response.body().string(), AutoresponsDTO.class);
            System.out.println(responsDTO.getToken());
            System.out.println("Response code is " + response.code());
            Assert.assertTrue(response.isSuccessful());
        } else {
            System.out.println("Response code is " + response.code());

            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
            System.out.println(errorDto.getStatus() + " " + errorDto.getError() + " "  +errorDto.getMessage());
            Assert.assertTrue(response.isSuccessful());

        }

    }

    @Test
    public void regpos() throws IOException {
        authRequestDTO requestDTO = authRequestDTO.builder().username("abc_" + i + "@def.com").password("$Abcdce12345").build();
        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO), Json);
        Request request = new Request.Builder().url(baseurl + "/" + path + "/" + "user/registration/usernamepassword").post(requestBody).build();
        Response response=okHttpClient.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());


    }
    @Test
    public void regNegWithWrongEmail() throws IOException {
        authRequestDTO requestDTO = authRequestDTO.builder().username("abc_" + i + "def.com").password("$Abcdce12345").build();
        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO), Json);
        Request request = new Request.Builder().url(baseurl + "/" + path + "/" + "user/registration/usernamepassword").post(requestBody).build();
        Response response=okHttpClient.newCall(request).execute();


        System.out.println("Response code is " + response.code());

        ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
        System.out.println(errorDto.getStatus() + " " + errorDto.getError() + " "  +errorDto.getMessage());
        Assert.assertTrue(!response.isSuccessful());

    }
    }



