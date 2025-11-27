package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDto {
    private Integer id;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private Double itemCostPrice;
    private Double itemSellingPrice;
    private Double itemLabeledPrice;
    private String itemCompany;
    private String itemDistributor;
}
