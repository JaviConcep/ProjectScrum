

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


public class UserController {

   
    private UserRepository userRepository;

  
    private CreditCardRepository creditCardRepository;

  
    public ResponseEntity<?> createUser(User user) {
        userRepository.save(user);
        return ResponseEntity.status(201).build();
    }


    public ResponseEntity<User> getUser(String username) {
        Optional<User> user = userRepository.findById(username);

        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

   
   
    public ResponseEntity<?> updateUser( String username,
                                        User updatedUser) {

        Optional<User> optionalUser = userRepository.findById(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setPassword(updatedUser.getPassword());
            user.setName(updatedUser.getName());
            user.setHomeAddress(updatedUser.getHomeAddress());

            userRepository.save(user);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


    public ResponseEntity<?> addCreditCard(String username,
                                            CreditCard card) {

        Optional<User> user = userRepository.findById(username);

        if (user.isPresent()) {
            card.setUser(user.get());
            creditCardRepository.save(card);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.notFound().build();
    }
}
