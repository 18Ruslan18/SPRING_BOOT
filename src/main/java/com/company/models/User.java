package com.company.models;

import com.company.forms.UserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fix_user")
public class User {
    @Override
    public int hashCode() {
        return Long.valueOf(getId()).hashCode();
    }
    @Override
    public boolean equals(Object o){
        if (this==o){
            return true;
        }
        if (o==null || getClass()!=o.getClass() ) {return false;}
        User that = (User) o;
        return this.getId()==that.getId();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;


    private String login;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
    //@OneToMany(mappedBy = "owner")
    ///private List<Car> cars;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> friends;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> followers;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> following;

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public void addFollowers(User user){this.followers.add(user);}
    public void addFollowing(User user){this.following.add(user);}
    public void addFriend(User user){
        this.friends.add(user);
    }
    public static User from(UserForm form) {
        return User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();
    }
}
