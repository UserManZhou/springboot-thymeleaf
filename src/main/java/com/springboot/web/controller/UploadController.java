package com.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.*;

@Controller
@Slf4j
public class UploadController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form_layouts";
    }

    @PostMapping("/upload")
    public String upload(
            @PathParam("email") String email,
            @PathParam("password") String password,
            @RequestPart("images")MultipartFile images,
            @RequestPart("phones") MultipartFile[] phones
            ) throws IOException {
        String originalFilename = images.getOriginalFilename();
        File file = new File("F:\\JavaCode\\Springboot\\springboot-web-thymeleaf\\images_from\\"+originalFilename);
//        if(!file.exists()) file.mkdir();
        OutputStream outputStream = new FileOutputStream(file);
        FileCopyUtils.copy(images.getBytes(), outputStream);
        return "redirect:main.html";
    }
}
