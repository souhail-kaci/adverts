package fr.souhail.adverts.entities;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_token")
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime expireDateTime;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpireDateTime() {
        return expireDateTime;
    }

    public void setExpireDateTime(LocalDateTime expireDateTime) {
        this.expireDateTime = expireDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
