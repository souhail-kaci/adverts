package fr.souhail.adverts.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;


    @Column(name = "password")
    public String password;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email",nullable = false)
    public String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users2groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    public Set<Role> roles;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
