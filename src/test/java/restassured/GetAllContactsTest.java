package restassured;

import Helper.contactHelper;
import com.jayway.restassured.RestAssured;
import dto.ContactDTO;
import dto.ContactListDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class GetAllContactsTest implements contactHelper

{
    String endpoint="contacts";



    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI=baseurl;
        RestAssured.basePath=path;
    }

    @Test
    public void getallcontatct(){

        ContactListDTO listDTo=   given()
              .header(authHeader,TOKEN)
                 .when()
                 .get(endpoint)
                 .then()
                 .assertThat().statusCode(200)
                 .extract()
                 .as(ContactListDTO.class);

        for(ContactDTO contactDTO:listDTo.getContacts()){
            System.out.println(contactDTO.getId());
            System.out.println("+++++++++++++++++++++");
            System.out.println(contactDTO.getName());
            System.out.println("+++++++++++++++++++++");
            System.out.println(contactDTO.getPhone());
        }

    }





}
