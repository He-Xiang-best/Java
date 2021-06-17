package service;


import model.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
