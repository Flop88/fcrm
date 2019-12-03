package ru.its67.fcrm.domain;

import javax.persistence.*;

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

    // Author
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    // ShorOrdersActive

    private String orderActive;

    //Constructors

    public Message() {
    }

    public Message(String firstDate, String orderDevice, String orderBrand,
                   String orderModel, String clientName, String clientPhone, User user, String orderActive) {
        this.author =  user;
        this.firstDate = firstDate;
        this.orderDevice = orderDevice;
        this.orderBrand = orderBrand;
        this.orderModel = orderModel;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.orderActive = orderActive;
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
}
