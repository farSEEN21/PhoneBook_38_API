package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter@ToString
public class authRequestDTO {
    String username;
    String password;
}
