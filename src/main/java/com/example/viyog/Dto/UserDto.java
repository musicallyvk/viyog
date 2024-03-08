package com.example.viyog.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private String userId;

    private String name;

    private String email;

    private Long mobileNumber;

    private String password;


}
