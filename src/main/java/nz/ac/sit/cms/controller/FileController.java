package nz.ac.sit.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * @program: cms
 * @description: Upload multimedia files
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-26 21:40
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ServletContext servletContext;
    @Value("${path.mediafile}")
    private String mediaFilePath;
    @Value("${url.serviceUrl}")
    private String serviceUrl;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws MalformedURLException {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide a valid image file");
        }
        String ROOT_PATH = mediaFilePath;
        try {
            String fileName = generateFileName(file.getOriginalFilename());
            Path filePath = new File(ROOT_PATH, fileName).toPath();
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String fileUrl = generateFileUrl(fileName);
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the image");
        }
    }

    private String generateFileName(String originalFilename) {
        String extension = StringUtils.getFilenameExtension(originalFilename);
        String fileName = UUID.randomUUID().toString();
        return fileName + "." + extension;
    }

    private String generateFileUrl(String fileName) {
        return serviceUrl + "/media_file/" + fileName;
    }

    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        System.out.println("path" + rootPath);
    }
}
