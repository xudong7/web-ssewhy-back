package com.dunjia.back.controller;

import com.dunjia.back.pojo.Result;
import com.dunjia.back.utils.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private UploadUtil uploadUtil;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("上传文件: {}", file.getOriginalFilename());
        String url = uploadUtil.localUpload(file);
        return Result.success(url);
    }
}
