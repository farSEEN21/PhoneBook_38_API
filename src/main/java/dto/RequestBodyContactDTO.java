package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class RequestBodyContactDTO {
//     "id": "string",
//             "name": "string",
//             "lastName": "string",
//             "email": "string",
//             "phone": "7794615366907",
//             "address": "string",
//             "description": "string"


    String id;
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;


}
