package com.house.start.service;

import com.house.start.domain.*;
import com.house.start.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ConsumerService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ConsumerRepository consumerRepository;
    @Autowired
    OrderRepository orderRepository;


    // 물건 정렬
    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }
    // 카테고리 별 물건 정렬
    public List<Item> getAllByCategory(Long id) {
        List<Item> items = itemRepository.findByCategory(id);
        return items;
    }
    // 물건 상세
    public Item getOneItem(Long id) {
        Item item = itemRepository.getById(id);
        return item;
    }

    // 장바구니 보기
    public List<Item> findItemByStatus(ItemStatus status) {
        List<Item> items = itemRepository.findByCart(ItemStatus.CART);
        return items;
    }

    // 장바구니 담기
    public void putCart(Long id) {
        Item item = itemRepository.getById(id);
        item.setItemStatus(ItemStatus.CART);
        itemRepository.save(item);
    }

    // 마이페이지
    public Consumer getConsumerInfo(Long id) {
        Consumer user = consumerRepository.getById(id);
        return user;
    }
    // 주문 목록
    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    // 배송 목록
    public List<Delivery> getAllDeliveries() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        return deliveries;
    }

    // 배송 완료
    @Transactional
    public void completeDelivery(Long id) {
        Delivery delivery = deliveryRepository.getById(id);
        Order order = delivery.getOrder();
        delivery.setDeliveryStatus(DeliveryStatus.COMPLETE);
        order.setOrderStatus(OrderStatus.COMPLETE);
        delivery.setReviewYn(true);

        deliveryRepository.save(delivery);
    }

    // 글 목록
    public List<Post> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }
    // 글 조회
    public Post getOnePost(Long id) {
        Post post = postRepository.getById(id);
        return post;
    }
    
    // 좋아요
    public void putLikes() {

    }
    
    // 글 작성
    @Transactional
    public void postNew(Post post) {
        postRepository.save(post);
    }


}
