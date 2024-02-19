package nogari.global.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private String id;
    private String pwd;
    private String useYn;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//        authList.add(new SimpleGrantedAuthority(grpAuthCd));
//        return authList;
        return null;
    }
    @Override
    public String getPassword() {
        return pwd;
    }
    @Override
    public String getUsername() {
        return id;
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
        return useYn.equals("Y");
    }

}