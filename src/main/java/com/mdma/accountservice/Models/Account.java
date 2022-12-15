package com.mdma.accountservice.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Account {
    @Id
    private String id;
    private String restaurantId;
    private String email;

    public Account(String id, String restaurantId, String email) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.email = email;
    }
}
