package net.walecode.restfulapiusermanagementcrud.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
