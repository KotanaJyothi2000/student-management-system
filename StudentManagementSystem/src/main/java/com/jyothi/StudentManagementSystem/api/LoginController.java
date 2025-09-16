package com.jyothi.StudentManagementSystem.api;

import com.jyothi.StudentManagementSystem.entities.User;
import com.jyothi.StudentManagementSystem.repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

@Controller
public class LoginController {

    private final UserRepo userRepo;

    public LoginController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/profile")
    public String ShowProfilePage(Model model, Principal principal){
        String username =principal.getName();
        User user = userRepo.findByUsername(username).orElse(null);
        model.addAttribute("user", user);
        return "profile";
    }
    // to upload profile pic
    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam("profilePic") MultipartFile file,
                                @RequestParam("aboutMe") String aboutMe,
                                Principal principal) {
        String username = principal.getName();
        User user = userRepo.findByUsername(username).orElse(null);
        if (user == null) {
            return "redirect:/login";
        }
        user.setAboutMe(aboutMe);
        if (!file.isEmpty()) {
            try {
                String fileName = username + "_" + file.getOriginalFilename();
                Path uploadPath = Paths.get("uploads");
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                user.setProfilePicPath(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        userRepo.save(user);
        return "redirect:/profile";
    }
    //to delete profile pic
    @PostMapping("/profile/delete-profilepic")
    public String deleteProfilePic(Principal principal) {
        String username = principal.getName();
        User user = userRepo.findByUsername(username).orElse(null);
        if (user != null && user.getProfilePicPath() != null) {
            Path filePath = Paths.get("uploads").resolve(user.getProfilePicPath());
            try {
                Files.deleteIfExists(filePath); // delete from disk
            } catch (IOException e) {
                e.printStackTrace();
            }
            user.setProfilePicPath(null); // remove from DB
            userRepo.save(user);
        }
        return "redirect:/profile";
    }
}
