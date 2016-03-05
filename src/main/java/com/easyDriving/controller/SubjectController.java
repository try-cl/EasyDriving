package com.easyDriving.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hexing on 15-12-15.
 */
@Controller
@RequestMapping("subject")
public class SubjectController {
    //上传视频
    @RequestMapping()
    public String index(){
        return "video";
    }
    @RequestMapping(value = "uploadvideo",method = RequestMethod.POST)
    public String uploadVideo(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException {
        JSONObject jsonObject = new JSONObject();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024*1024*500);
        File file = new File("/home/hexing/max");
        factory.setRepository(file);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024*1024*1024);
        List<FileItem> items = upload.parseRequest(request);
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if(!item.isFormField()){
                String fieldName = item.getFieldName();
                String fileName = item.getName();
                String contentType = item.getContentType();
                long sizeInBytes = item.getSize();
                System.out.println(fieldName);
                System.out.println(fileName);
                System.out.println(contentType);
                System.out.println(sizeInBytes);
                InputStream inputStream = item.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                fileName = "/home/hexing/video/"+fileName;
                System.out.println(fileName);
                OutputStream outputStream = new FileOutputStream(fileName);
                while ((len = inputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,len);
                }

                outputStream.close();
                inputStream.close();
            }

        }
        jsonObject.put("result","success");
        return "success";
    }
}
