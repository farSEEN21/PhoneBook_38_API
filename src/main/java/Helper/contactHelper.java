package Helper;

import com.google.gson.Gson;
import dto.RequestBodyContactDTO;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.Random;

public interface contactHelper {
    MediaType Json = MediaType.get("application/json; charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();

    String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYUBhMS5ydSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNjkxNDI3MzM2LCJpYXQiOjE2OTA4MjczMzZ9.icpHlIF_K8uxFZHblU8obnkQQEBCNaNEcw2jIAvcl-k";
    String baseurl="https://contactapp-telran-backend.herokuapp.com";
    String path="v1";
    int i =new Random().nextInt(1000)+1000;

    default RequestBodyContactDTO createContact() {
        String i = Integer.toString((int) (System.currentTimeMillis() / 1000) % 3600);

        RequestBodyContactDTO requestBodyContactDTO = RequestBodyContactDTO.builder().
                id(generateRandomText())
                .name(generateRandomText())
                .lastName(generateRandomText())
                .email(generateRandomEmail())
                .phone(generateRandomnumber())
                .address(generateRandomText())
                .description(generateRandomText()).build();


        return requestBodyContactDTO;
    }

    default String generateRandomnumber() {
        String allowedCharacters = "0123456789";


        Random random = new Random();

        String number = "";
        int length = allowedCharacters.length();

        for (int i = 0; i < 12; i++) {
            int randomIndex = random.nextInt(length);
            number = number + allowedCharacters.charAt(randomIndex);

        }

        return number;
    }


    default String generateRandomEmail() {
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
        String domain = "gmail.com";

        Random random = new Random();

        String email = "";
        int length = allowedCharacters.length();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(length);
            email = email + allowedCharacters.charAt(randomIndex);

        }

        email = email + "@" + domain;


        return email;
    }

    default String generateRandomText() {
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";


        Random random = new Random();

        String text = "";
        int length = allowedCharacters.length();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(length);
            text = text + allowedCharacters.charAt(randomIndex);

        }


        return text;
    }

    default String generateRandompsw() {
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$^&*abcdefghijklmnopqrstuvwxyz";


        Random random = new Random();

        String text = "";
        int length = UPPER.length();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(length);
            text = text + UPPER.charAt(randomIndex);

        }


        return text;
    }

    String authHeader = "Authorization";
}
