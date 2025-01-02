package com.dunjia.back.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class UploadUtil {

    @Value("${imagepath}")
    private String imagepath;
    @Value("${serverforimagepath}")
    private String serverforimagepath;

    /**
     * 上传图片到本地
     * @param image
     * @return
     * @throws IOException
     */
    public String localUpload(MultipartFile image) throws IOException {
        // 将前端传来的图片存到本地(如果没有文件夹，则创建一个)，同时将图片在本地的路径返回，使用/image/**访问
        String originalFilename = image.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        File file = new File(imagepath + fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        return serverforimagepath + fileName;
    }
}
