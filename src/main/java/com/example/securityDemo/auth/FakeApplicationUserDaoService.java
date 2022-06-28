package com.example.securityDemo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.securityDemo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
    return getApplicationUsers()
        .stream()
        .filter(user -> username.equals(user.getUsername()))
        .findFirst();
  }

  private List<ApplicationUser> getApplicationUsers() {
    List<ApplicationUser> applicationUserList = Lists.newArrayList(
        new ApplicationUser("annaSmith",
            passwordEncoder.encode("password"),
            STUDENT.getGrantedAuthorities(),
            true,
            true,
            true,
            true
        ),
        new ApplicationUser("linda",
            passwordEncoder.encode("password"),
            ADMIN.getGrantedAuthorities(),
            true,
            true,
            true,
            true
        ),
        new ApplicationUser("tom",
            passwordEncoder.encode("password"),
            ADMIN_TRAINEE.getGrantedAuthorities(),
            true,
            true,
            true,
            true
        )
    );
    return applicationUserList;
  }

}
