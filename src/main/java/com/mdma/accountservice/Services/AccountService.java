package com.mdma.accountservice.Services;

import com.mdma.accountservice.Models.Account;
import com.mdma.accountservice.Repositorys.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public ResponseEntity<String> PostAccount(Account account) {
        account.setEmail(account.getEmail().toLowerCase());
        if(accountRepository.save(account) != account) {
            return new ResponseEntity<String>("Account hasn't been saved", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Account has been saved", HttpStatus.OK);
    }

    public ResponseEntity<Boolean> CheckAccount(String restaurantId, String email) {
        String lowerEmail = email.toLowerCase();
        return new ResponseEntity<>(accountRepository.existsAccountByRestaurantIdAndEmail(restaurantId, lowerEmail), HttpStatus.OK);
    }

    public ResponseEntity<Account> GetRestaurantIdByEmail(String email) {
        String lowerEmail = email.toLowerCase();
        return new ResponseEntity<>(accountRepository.findFirstByEmail(lowerEmail), HttpStatus.OK);
    }
}
