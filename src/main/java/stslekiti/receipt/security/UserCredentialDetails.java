package stslekiti.receipt.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import stslekiti.receipt.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserCredentialDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    private boolean active;

    public UserCredentialDetails(User user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.authorities = Stream.of(user.getRole().name())
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        this.active = user.getActive();
    }

    public UserCredentialDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
