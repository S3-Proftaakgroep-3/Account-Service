package com.mdma.accountservice.Repositorys;

import com.mdma.accountservice.Models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    Boolean existsAccountByRestaurantIdAndEmail(String restaurantId, String email);
    Account findFirstByEmail(String email);
}
