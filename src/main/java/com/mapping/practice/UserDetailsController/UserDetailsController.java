package com.mapping.practice.UserDetailsController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.practice.Entities.UserDetails;
import com.mapping.practice.repository.UserDetailsRepository;
//Controller class for handling RestApi's
@RestController
@RequestMapping("/api/v1")
public class UserDetailsController {
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    //Get All User Details
    @GetMapping("/userdetails")
    public List<UserDetails> getAllUser(){
        return userDetailsRepository.findAll();
    }

    //Get single User Details
    @GetMapping("/userdetails/{id}")
    public Optional<UserDetails> getUser(@PathVariable("id") int id){
        Optional<UserDetails> user = userDetailsRepository.findById((long) id);
        return user;
    }

    //Create new user details
    @PostMapping("/userdetails")
    public UserDetails createUser(@RequestBody UserDetails userDetails){
        return userDetailsRepository.save(userDetails);
    }

    //Update User Details
    @PutMapping("/userdetails/{id}")
    public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userdetails,@PathVariable("id") Long id)throws NotFoundException{
            UserDetails user = userDetailsRepository.findById(id).orElseThrow(() -> new NotFoundException("Userdetails not Found :: " + id));
            user.setEmail(userdetails.getEmail());
            user.setFirstName(userdetails.getFirstName());
            user.setLastName(userdetails.getLastName());
            user.setUserSettings(userdetails.getUserSettings());
            final UserDetails updateUser = userDetailsRepository.save(user);
            return ResponseEntity.ok(updateUser);
    }

    //Delete User Details
    @DeleteMapping("/userdetails/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable ("id") Long usrId)throws NotFoundException{
        UserDetails userDetails = userDetailsRepository.findById(usrId).orElseThrow(() -> new NotFoundException("UserDetails not found :: " + usrId));
        userDetailsRepository.delete(userDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
