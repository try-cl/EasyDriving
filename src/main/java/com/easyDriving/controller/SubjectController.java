package com.easyDriving.controller;

import com.easyDriving.pojo.Subject;
import com.easyDriving.service.SubjectService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private SubjectService subjectService;

    @RequestMapping()
    public String index(){
        return "video";
    }

    @RequestMapping(value = "addtest",method = RequestMethod.POST)
    public @ResponseBody String addTest(@RequestParam String s_chapter,@RequestParam String s_type,@RequestParam String addtest,HttpServletRequest request,HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        Subject subject = new Subject();
        subject.setS_chapter(s_chapter);
        subject.setS_type(s_type);
        String[] addtests = addtest.split("_ueditor_page_break_tag_");
        System.out.println(addtests.length);
        for (int i = 0; i < addtests.length;i++){
            String[] strs = addtests[i].split("</p>");
            int length = strs.length;
            System.out.println(length);
            switch (length)
            {
                case 5:
                    subject.setS_content(strs[0].substring(3));
                    subject.setAnswer_a(strs[1].substring(3));
                    subject.setAnswer_b(strs[2].substring(3));
                    subject.setAnswer(strs[3].substring(7));
                    subject.setS_analyze(strs[4].substring(7));
                    break;
                case 6:
                    subject.setS_content(strs[0].substring(3));
                    subject.setAnswer_a(strs[1].substring(3));
                    subject.setAnswer_b(strs[2].substring(3));
                    subject.setAnswer(strs[3].substring(7));
                    subject.setS_analyze(strs[4].substring(7));
                    subject.setS_image(strs[5].split("image/|\"")[2]);
                    break;
                case 7:
                    subject.setS_content(strs[0].substring(3));
                    subject.setAnswer_a(strs[1].substring(3));
                    subject.setAnswer_b(strs[2].substring(3));
                    subject.setAnswer_c(strs[3].substring(3));
                    subject.setAnswer_d(strs[4].substring(3));
                    subject.setAnswer(strs[5].substring(7));
                    subject.setS_analyze(strs[6].substring(7));
                    break;
                case 8:
                    subject.setS_content(strs[0].substring(3));
                    subject.setAnswer_a(strs[1].substring(3));
                    subject.setAnswer_b(strs[2].substring(3));
                    subject.setAnswer_c(strs[3].substring(3));
                    subject.setAnswer_d(strs[4].substring(3));
                    subject.setAnswer(strs[5].substring(7));
                    subject.setS_analyze(strs[6].substring(7));
                    subject.setS_image(strs[7].split("image/|\"")[2]);
                    break;
                default:
                    jsonObject.put("result",i);
                    System.out.println(jsonObject.toString());
                    return jsonObject.toString();
            }
            subjectService.addTest(subject);
        }
        jsonObject.put("result","success");
        return jsonObject.toString();
    }

    @RequestMapping(value = "uploadvideo",method = RequestMethod.POST)
    public String uploadVideo(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException {
        JSONObject jsonObject = new JSONObject();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024*1024*500);
        File file = new File("/home/hexing/video");
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
