package ru.its67.fcrm.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // ADD NEW ORDER

    private String firstDate;
    private String orderDevice;
    private String orderBrand;
    private String orderModel;
    private String clientName;
    private String clientPhone;
    private String orderComment;
    private String orderComplect;
    private String orderProblem;

    // EDIT ORDER
    private String orderServices;
    private String orderPrice;
    private String secondDate;
    private String orderExpenses;
    private String orderGaranty;

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
                   String orderModel, String clientName, String clientPhone, String orderProblem, User user, String orderActive, String orderComment, String orderComplect) {
        this.author =  user;
        this.firstDate = firstDate;
        this.orderDevice = orderDevice;
        this.orderBrand = orderBrand;
        this.orderModel = orderModel;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.orderProblem = orderProblem;
        this.orderActive = orderActive;
        this.orderComment = orderComment;
        this.orderComplect = orderComplect;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getOrderComplect() {
        return orderComplect;
    }

    public void setOrderComplect(String orderComplect) {
        this.orderComplect = orderComplect;
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

    public String getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    public String getOrderExpenses() {
        return orderExpenses;
    }

    public void setOrderExpenses(String orderExpenses) {
        this.orderExpenses = orderExpenses;
    }

    public String getOrderGaranty() {
        return orderGaranty;
    }

    public void setOrderGaranty(String orderGaranty) {
        this.orderGaranty = orderGaranty;
    }

    public String getOrderProblem() {
        return orderProblem;
    }

    public void setOrderProblem(String orderProblem) {
        this.orderProblem = orderProblem;
    }

}
