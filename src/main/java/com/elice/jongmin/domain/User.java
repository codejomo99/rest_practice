package com.elice.jongmin.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {
// UserDetails -> 인증 객체로 사용하기 위함
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",updatable = false)
  private Long id;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Builder
  public User(String email, String password, String auth){
    this.email = email;
    this.password = password;
  }


  @Override //권한 반환
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("user"));
  }

  @Override // 사용자의 id를 반환
  public String getUsername() {
    return email;
  }

  @Override //사용자의 패스워드를 반환
  public String getPassword() {
    return password;
  }

  @Override //계정 만료 여부
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override // 계정 잠금 여부 반환
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override // 패스워드의 만료 여부 반환
  public boolean isCredentialsNonExpired() {
    // 패스워드가 만료되었는지 확인하는 로직
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
