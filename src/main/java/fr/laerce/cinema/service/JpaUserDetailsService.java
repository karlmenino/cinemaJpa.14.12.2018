package fr.laerce.cinema.service;

import fr.laerce.cinema.dao.UserDao;
import fr.laerce.cinema.model.Groups;
import fr.laerce.cinema.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Projet thyme-security
 * Pour LAERCE SAS
 * <p>
 * Créé le  21/03/2017.
 *
 * @author fred
 */
@Service
public class JpaUserDetailsService implements UserDetailsService {


    private UserDao userDao;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByLogin (username);
        log.info("Recherche utilisateur: "+username);
        if(user == null){
            throw new UsernameNotFoundException ("Utilisateur introuvable : |"+username+"|");
        }
        Set<GrantedAuthority> authorities = new HashSet<> ();
        for(Groups grp: user.getGroups()){
            log.info("{username: "+username+"| grp: "+grp.getRole());
            authorities.add(new SimpleGrantedAuthority (grp.getRole()));
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder ();
        System.out.println(encoder.matches("p@ssw0rd", user.getPassword()));

        return new org.springframework.security.core.userdetails.User(
                user.getLogin (),
                user.getPassword(),
                authorities);
    }
}
