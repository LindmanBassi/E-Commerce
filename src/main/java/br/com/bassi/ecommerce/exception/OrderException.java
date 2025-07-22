package br.com.bassi.ecommerce.exception;

public class OrderException extends RuntimeException{

    public OrderException(String message) {
        super(message);
    }
}
