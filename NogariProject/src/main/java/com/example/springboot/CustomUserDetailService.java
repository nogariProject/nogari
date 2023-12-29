//package com.example.springboot;
//
//import com.example.springboot.data.entity.User;
//import com.example.springboot.data.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@AllArgsConstructor
//public class CustomUserDetailService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if(user == null){
//            throw new UsernameNotFoundException("No user with "+username+" exist in the database");
//        }
//
//        return null;
//    }
//
//}
