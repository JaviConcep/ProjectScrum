

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    // User Creation
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.status(201).build();
    }

    // User Call.
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        Optional<User> user = userRepository.findById(username);

        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Updates
    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username,
                                        @RequestBody User updatedUser) {

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

    // Adds Card.
    @PostMapping("/{username}/credit-card")
    public ResponseEntity<?> addCreditCard(@PathVariable String username,
                                           @RequestBody CreditCard card) {

        Optional<User> user = userRepository.findById(username);

        if (user.isPresent()) {
            card.setUser(user.get());
            creditCardRepository.save(card);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.notFound().build();
    }
}
