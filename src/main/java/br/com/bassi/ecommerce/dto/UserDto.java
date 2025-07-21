package br.com.bassi.ecommerce.dto;

public record UserDto(String fullName,
                      String address,
                      String number,
                      String complement) {
}
