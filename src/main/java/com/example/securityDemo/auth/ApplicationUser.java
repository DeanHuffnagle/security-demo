package com.example.securityDemo.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ApplicationUser implements UserDetails {

  private final String username;
  private final String password;
  private final List<? extends GrantedAuthority> grantedtAuthorities;
  private final boolean isAccountNonExpired;
  private final boolean isAccountNonLocked;
  private final boolean isCredentialsNonExpired;
  private final boolean isEnabled;


  public ApplicationUser(String username,
                         String password,
                         List<? extends GrantedAuthority> grantedtAuthorities,
                         boolean isAccountNonExpired,
                         boolean isAccountNonLocked,
                         boolean isCredentialsNonExpired,
                         boolean isEnabled) {
    this.grantedtAuthorities = grantedtAuthorities;
    this.username = username;
    this.password = password;
    this.isAccountNonExpired = isAccountNonExpired;
    this.isAccountNonLocked = isAccountNonLocked;
    this.isCredentialsNonExpired = isCredentialsNonExpired;
    this.isEnabled = isEnabled;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedtAuthorities;
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
    return isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }
}