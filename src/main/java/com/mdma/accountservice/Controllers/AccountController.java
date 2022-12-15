package com.mdma.accountservice.Controllers;

import com.mdma.accountservice.Models.Account;
import com.mdma.accountservice.Services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<String> CreateOrder(@RequestBody Account account) {
        return accountService.PostAccount(account);
    }

    @GetMapping("/check/{restaurantId}/{email}")
    public ResponseEntity<Boolean> CreateOrder(@PathVariable String restaurantId, @PathVariable String email) {
        return accountService.CheckAccount(restaurantId, email);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Account> GetRestaurantIdByEmail(@PathVariable String email) {
        return accountService.GetRestaurantIdByEmail(email);
    }
}
