package okhttp;

import Helper.contactHelper;
import dto.ContactDTO;
import dto.ContactResponseDTO;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteContactsByIdTest implements contactHelper {

    String endpoint = "contacts";
    String id;
@BeforeMethod
public void precondition() throws IOException {
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
     id = message.substring(message.lastIndexOf(" ") + 1);

}
    @Test
    public void deleteContactByIDPositive() throws IOException {

        Request request = new Request.Builder()
                .url(baseurl + "/" + path + "/" + endpoint + "/" + id)
                .addHeader("Authorization", TOKEN)
                .delete()
                .build();
        Response response = okHttpClient.newCall(request).execute();

        ContactResponseDTO contactResponseDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
        Assert.assertTrue(response.isSuccessful());
        String message = contactResponseDTO.getMessage();
        System.out.println(message);


    }

}
