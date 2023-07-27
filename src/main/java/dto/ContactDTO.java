package dto;

import Helper.contactHelper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class ContactDTO {
//          "id": "string",
//                  "name": "string",
//                  "lastName": "string",
//                  "email": "string",
//                  "phone": "20901784743289",
//                  "address": "string",
//                  "description": "string"
String id;
String name;
String lastName;
String email;
String phone;
String address;
String description;

}
