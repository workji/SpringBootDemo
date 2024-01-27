package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadTest {

    @Value("${web.upload-path}")
    private String uploadPath;

    @GetMapping("/")
    public String test(Map<String, Object> map) {
        map.put("title", "Upload Test");
        return "upload/index";
    }

    @PostMapping("/single1")
    public String uploadTest01(@RequestParam("file1") MultipartFile uploadFile, ModelMap map) {
        map.put("title", uploadFile.getOriginalFilename());
        return "upload/index";
    }

    @PostMapping("/single2")
    public String uploadTest011(MultipartFile file1, HttpServletRequest request, ModelMap map) throws IOException {

        String format = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        String oldName = file1.getOriginalFilename();
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            file1.transferTo(new File(folder, newName));
            String filePath = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort()  + format + newName;
            map.put("title", filePath);
        } catch (IOException e) {
        }

        return "upload/index";
    }

    @PostMapping("/multiple1")
    public String uploadTest02(@RequestParam("file1") MultipartFile[] files, ModelMap map) {
        StringBuffer okFileName = new StringBuffer("fileName = ");
        for (MultipartFile file : files) {
            okFileName.append(file.getOriginalFilename());
            okFileName.append(" - ");
        }
        map.put("title", okFileName.toString());
        return "upload/index";
    }

    @PostMapping("/multiple2")
    public String uploadTest03(MultipartFile file1, MultipartFile file2, MultipartFile file3, ModelMap map) {
        map.put("title", file1.getOriginalFilename() + file2.getOriginalFilename() + file3.getOriginalFilename());
        return "upload/index";
    }
}
