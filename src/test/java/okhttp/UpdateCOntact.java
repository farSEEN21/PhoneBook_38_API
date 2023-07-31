package okhttp;

import dto.ContactDTO;
import dto.ContactResponseDTO;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Helper.contactHelper;

import java.io.IOException;

import static Helper.contactHelper.*;
import static Helper.contactHelper.baseurl;

public class UpdateCOntact implements contactHelper {
    String endpoint = "contacts";
    String id;

    ContactDTO contactDTO = ContactDTO.builder()
            .name("Aq39.")
            .lastName("auth")
            .email("qa38" + i + "@gmail.com")
            .phone("99123109876" + i)
            .address("regove")
            .description("St")
            .build();

    @BeforeMethod
    public void precondition() throws IOException {


        RequestBody requestBody = RequestBody.create(gson.toJson(contactDTO), Json);

        Request request = new Request.Builder()
                .url(baseurl + "/" + path + "/" + endpoint)
                .addHeader("Authorization", TOKEN).post(requestBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        ContactResponseDTO contactResponseDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
        String message = contactResponseDTO.getMessage();

        id = message.substring(message.lastIndexOf(" ") + 1);
    }

    @Test

    public void UpadateContactPhone() throws IOException {

        contactDTO = ContactDTO.builder()
                .id(id)
                .name("Aq39."+i)
                .lastName("auth1")
                .email("qa38" + i + "@gmail.com")
                .phone("123456789034")
                .address("regove")
                .description("St")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(contactDTO), Json);
        Request request = new Request.Builder()
                .url(baseurl + "/" + path + "/" + endpoint)
                .addHeader("Authorization", TOKEN).put(requestBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
    }
}
