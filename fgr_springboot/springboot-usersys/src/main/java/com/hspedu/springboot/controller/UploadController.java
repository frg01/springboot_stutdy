package com.hspedu.springboot.controller;

import com.hspedu.springboot.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
@Slf4j
public class UploadController {

    //处理转发到用户注册
    @GetMapping("/upload.html")
    public String uploadPage(){
        return "upload";//视图解析，转发到templates/upload.html
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("age") Integer age,
                         @RequestParam("job") String job,
                         @RequestParam("header") MultipartFile header,
                         @RequestParam("photos") MultipartFile[] photos
                         ) throws IOException {
        //输出获取到的信息
        log.info("上传的信息 name={} email={} age={} job={} header={} photos={}" ,
        name,email,age,job,header.getSize(),photos.length);
        //如果信息成功获取到，将文件保存到指定的目录
        String path = ResourceUtils.getURL("classpath:").getPath();
        File file = new File(path + WebUtils.getYearMonthDay());
        if (!file.exists()){//如果目录不存在
            file.mkdirs();
        }

        log.info("path={}" , path);

        if (!header.isEmpty()){//头像文件
            //上传文件的原名
            String originalFilename = header.getOriginalFilename();
            String randomName = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_";
//            header.transferTo(new File("D:\\temp_upload\\" + originalFilename));
            log.info("保存文件的绝对路径={}" + file.getAbsolutePath());
            header.transferTo(new File(file.getAbsoluteFile() + "/" + randomName +  originalFilename));
        }
        if (photos.length > 0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    String randomName = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_";
//                    photo.transferTo(new File("D:\\temp_upload\\" + originalFilename));
                    photo.transferTo(new File(file.getAbsoluteFile() + "/" + randomName + originalFilename));
                }
            }
        }

        return "注册成功/文件上传成功-";
    }
}
