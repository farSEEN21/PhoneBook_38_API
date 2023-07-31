package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Builder
@Getter
@Setter
public class ContactListDTO {

    List<ContactDTO> contacts;


}
