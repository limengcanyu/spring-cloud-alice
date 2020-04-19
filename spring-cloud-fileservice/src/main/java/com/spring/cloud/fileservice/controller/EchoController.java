package com.spring.cloud.fileservice.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2019/12/25 10:57
 */
@Api("hello app")
@Slf4j
@RestController
public class EchoController {
    /**
     * localhost:8100/upload
     *
     * MultipartAutoConfiguration
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam MultipartFile file, HttpServletRequest request) {
        log.debug("calling UploadService upload");

        log.debug("request.getContentType: {}", request.getContentType());
        String originalFilename = file.getOriginalFilename();
        log.debug("originalFilename: {}", originalFilename);

        try {
            assert originalFilename != null;
            file.transferTo(new File(originalFilename));
        } catch (IOException e) {
            e.printStackTrace();

            return "upload file error";
        }

        return "upload file success";
    }

}
