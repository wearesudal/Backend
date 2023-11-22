package com.sudal.home.domain.user.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserDetails {
    //private static final long serialVersionUID = -8360090276325048821L;

    private Integer userIdx;
    private String userId;
	private String userName;
	private String userPass;
	private String userEmail;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public Integer getUserIndex() { return this.userIdx; }
	@Override
	public String getUsername() { return this.userId; }
	@Override
    public String getPassword() { return this.userPass; }

   @Override
   public boolean isAccountNonExpired() { return true; }

   @Override
   public boolean isAccountNonLocked() { return true; }

   @Override
   public boolean isCredentialsNonExpired() { return true; }

   @Override
   public boolean isEnabled() { return true; }
}
