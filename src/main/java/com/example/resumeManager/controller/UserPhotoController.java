package com.example.resumeManager.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.resumeManager.dto.UserPhotoDto;
import com.example.resumeManager.service.UserPhotoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserPhotoController {

    @Autowired
    UserPhotoService service;

    @Value("${file.upload.path}")
    private String uploadPath;

    @PostMapping("/uploadPhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file,
                              HttpSession session) throws IOException {

        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/loginForm";
        }

        if (file == null || file.isEmpty()) {
            return "redirect:/mypage";
        }

        String originalName = file.getOriginalFilename();
        String savedName = UUID.randomUUID() + "_" + originalName;

        File saveFile = new File(uploadPath, savedName);
        file.transferTo(saveFile);

        service.deletePhotoByUserId(userId);

        UserPhotoDto dto = new UserPhotoDto();
        dto.setUserId(userId);
        dto.setFileName(savedName);
        dto.setOriginalName(originalName);

        service.insertPhoto(dto);

        return "redirect:/mypage";
    }
}