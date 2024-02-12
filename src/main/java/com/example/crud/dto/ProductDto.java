package com.example.crud.dto;

import java.util.Date;
import com.example.crud.model.Category;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductDto {

	private long productId;

	private String productName;

	private String productDescription;

	private double price;

	private int quantity;

	private Category category;
}
