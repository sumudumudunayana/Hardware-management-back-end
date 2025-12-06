package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DistributorDto {
    private Integer id;
    private String distributorName;
    private String distributorDescription;
    private Integer distributorContactNumber;
    private String distributorEmail;
}
