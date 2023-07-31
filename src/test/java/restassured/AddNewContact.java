package restassured;

import Helper.contactHelper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AutoresponsDTO;
import dto.ContactDTO;
import dto.ContactResponseDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class AddNewContact implements contactHelper {

    String endpoint="contacts";


    @BeforeMethod
    public void precond(){
        RestAssured.baseURI=baseurl;
        RestAssured.basePath=path;
    }
@Test
    public void addcontact(){

    ContactDTO contactDTO= ContactDTO.builder()
            .id("")
            .name("fdsfdsf")
            .lastName("sdfdsfdsf")
            .email("sadasd"+i+"@dsfs.com")
            .phone("12332214324"+i)
            .address("dsfsdfsdfds")

            .description("sdadasdas").build();


    ContactResponseDTO contactResponseDTO=  given().header("Authorization",TOKEN)
            .body(contactDTO)
            .contentType(ContentType.JSON)
            .when()
            .post(endpoint)
            .then()
            .assertThat().statusCode(200)
            .extract()
            .as(ContactResponseDTO.class);


}






}
