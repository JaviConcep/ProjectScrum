
import jakarta.persistence.*;


public class CreditCard {

  
    private Long id;

    private String cardNumber;
    private String expirationDate;
    private int cvv;

    
    private User user;

    public CreditCard() {}

    public CreditCard(String cardNumber, String expirationDate, int cvv, User user) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    public int getCvv() { return cvv; }
    public void setCvv(int cvv) { this.cvv = cvv; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
