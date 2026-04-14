package com.carlos.navarro.InnovaTech.CR.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private List<CartItemResponse> items;
    private Double total;
}
