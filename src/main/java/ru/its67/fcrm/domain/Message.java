package ru.its67.fcrm.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;



    // ADD NEW ORDER

    private String firstDate;
    private String orderDevice;
    private String orderBrand;
    private String orderModel;
    private String clientName;
    private String clientPhone;
    private String orderComment;

    // EDIT ORDER
    private String orderServices;
    private String orderPrice;
    private String order_seconddate;
    private String order_expenses;

    private String order_garanty;

    // Author
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    // ShorOrdersActive

    private String orderActive;

    //Сет заказов
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Message> messages;


    //Constructors

    public Message() {
    }

    public Message(String firstDate, String orderDevice, String orderBrand,
                   String orderModel, String clientName, String clientPhone, User user, String orderActive, String orderComment) {
        this.author =  user;
        this.firstDate = firstDate;
        this.orderDevice = orderDevice;
        this.orderBrand = orderBrand;
        this.orderModel = orderModel;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.orderActive = orderActive;
        this.orderComment = orderComment;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getOrderDevice() {
        return orderDevice;
    }

    public void setOrderDevice(String orderDevice) {
        this.orderDevice = orderDevice;
    }

    public String getOrderBrand() {
        return orderBrand;
    }

    public void setOrderBrand(String orderBrand) {
        this.orderBrand = orderBrand;
    }

    public String getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(String orderModel) {
        this.orderModel = orderModel;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(String orderActive) {
        this.orderActive = orderActive;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(String orderServices) {
        this.orderServices = orderServices;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrder_seconddate() {
        return order_seconddate;
    }

    public void setOrder_seconddate(String order_seconddate) {
        this.order_seconddate = order_seconddate;
    }

    public String getOrder_expenses() {
        return order_expenses;
    }

    public void setOrder_expenses(String order_expenses) {
        this.order_expenses = order_expenses;
    }

    public String getOrderGaranty() {
        return order_garanty;
    }

    public void setOrderGaranty(String orderGaranty) {
        this.order_garanty = orderGaranty;
    }
}
