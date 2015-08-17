package org.wws.springSecurity;





import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wws.dao.UserDAO;
import org.wws.pojo.Role;

//@Service
@Transactional(readOnly=true)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired 
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		org.wws.pojo.User domainUser = userDAO.getUserByUserName(userName);
		
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
		
		
		return new User(domainUser.getUsername(), 
				domainUser.getPassword(), 
				enabled, accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked, 
				getAuthorities(domainUser.getRoles()));
	            
	    
	}
	
	
	public List<String> getRolesAsList(Set<Role> roles) {
	    List <String> rolesAsList = new ArrayList<String>();
	    for(Role role : roles){
	        rolesAsList.add(role.getAuthority());
	    }
	    return rolesAsList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (String role : roles) {
	        authorities.add(new SimpleGrantedAuthority(role));
	    }
	    return authorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
	    List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(roles));
	    return authList;
	}

}
