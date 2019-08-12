package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/img")
public class ImageController {

    @RequestMapping
    public String index() {
        return "image";
    }

    @Value("com.asiainfo.img.path")
    public String path ;

    @RequestMapping("/upload")
    public void upload(@RequestParam("image") MultipartFile file,
                       HttpServletRequest request) throws IOException {

        //根据相对路径获取绝对路径，图片上传后位于元数据中
        String realUploadPath=request.getServletContext().getRealPath("/")+"images";
        //获取上传后原图的相对地址
        String imageUrl=Upload.uploadImage(file, realUploadPath);

        System.out.println(imageUrl);
        //获取生成的缩略图的相对地址
        //String thumbImageUrl=thumbnail.generateThumbnail(file, realUploadPath);
        //return "redirect:/images";
    }

    @RequestMapping("/view")
    public void view(MultipartFile[] file) {

    }

    @RequestMapping("/download")
    public void download(MultipartFile[] file) {

    }



}

class Upload {

    /*
     * 上传图片并返回图片的相对地址
     */
    public static String uploadImage(MultipartFile file,String realUploadPath) throws IOException
    {
        //如果目录不存在则创建目录
        File uploadFile=new File(realUploadPath+"/rawImages");
        if(!uploadFile.exists()){
            uploadFile.mkdirs();
        }

        //创建输入流
        InputStream inputStream=file.getInputStream();
        //生成输出地址URL
        String outputPath=realUploadPath+"/rawImages/"+file.getOriginalFilename();
        //创建输出流
        OutputStream outputStream=new FileOutputStream(outputPath);
        //设置缓冲区
        byte[] buffer=new byte[1024];

        //输入流读入缓冲区，输出流从缓冲区写出
        while((inputStream.read(buffer))>0)
        {
            outputStream.write(buffer);
        }
        outputStream.close();

        //返回原图上传后的相对地址
        return "images/rawImages/"+file.getOriginalFilename();
    }

}