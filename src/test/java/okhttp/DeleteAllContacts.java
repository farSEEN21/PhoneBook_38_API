package okhttp;

import Helper.contactHelper;
import dto.ContactResponseDTO;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteAllContacts implements contactHelper
{
    String endpoint = "contacts/clear";
    String id;

@Test

public void deleteAllContactposit() throws IOException {

    Request request = new Request.Builder()
            .url(baseurl + "/" + path + "/" + endpoint)
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
