package com.bit.shop.dto;

import com.bit.shop.domain.Product;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class LikeProductDto {

  private String name;
  private Long price;

  public static LikeProductDto getFromProduct(Product product) {
    return new LikeProductDto(product.getName(),product.getPrice());
  }


  public LikeProductDto convert(Product product) {
    return new LikeProductDto(product.getName(), product.getPrice());
  }

  public List<LikeProductDto> convert(List<Product> list){
    return list.stream().map(LikeProductDto::getFromProduct).collect(Collectors.toList());
  }
}
