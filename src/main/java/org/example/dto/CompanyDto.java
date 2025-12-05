package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyDto {
    private Integer id;
    private String companyName;
    private String companyDescription;
    private String companyAddress;
    private Integer companyContactNumber;
    private String companyEmail;
}
