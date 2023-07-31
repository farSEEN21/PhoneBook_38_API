package restassured;

import Helper.contactHelper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AutoresponsDTO;
import dto.ErrorDto;
import dto.authRequestDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

public class LoginTest implements contactHelper {

    String endpoint = "user/login/usernamepassword";

    @BeforeMethod
    public void precondition() {


        RestAssured.baseURI = baseurl;
        RestAssured.basePath = path;


    }


    @Test
    public void LoginPositiv() {


        authRequestDTO requestDTO = authRequestDTO.builder()
                .username("a@a1.ru")
                .password("DJS@sda1").build();

        authRequestDTO responseDTO=    given()
                .body(requestDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .as(authRequestDTO.class);


    }
    @Test
    public void LoginNeg() {


        authRequestDTO requestDTO = authRequestDTO.builder()
                .username("a@a1.ru")
                .password("DJS@sda1").build();

        given()
                .body(requestDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(401)
                .extract()
                .as(ErrorDto.class);
//        System.out.println(ErrorDto.getMessage());
    }


}
