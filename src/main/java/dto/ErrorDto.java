package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class ErrorDto {


    int status;
    String error;
  Object message;

    //      "timestamp": "2023-07-25T16:08:31.689Z",
//              "status": 0,
//              "error": "string",
//              "message": {},
//            "path": "string"

}
