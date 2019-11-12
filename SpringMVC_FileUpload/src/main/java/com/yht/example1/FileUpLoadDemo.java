package com.yht.example1;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * SpringMVC的文件上传和传统方式的文件上传
 *
 */

@Controller
@RequestMapping("/file")
public class FileUpLoadDemo {

    /**
     * 传统方式的文件上传
     * @param request
     * @return
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File  file = new File(path);
        //如果文件夹不存在，创建文件夹
        if(!file.exists()){
            file.mkdirs();
        }

        //解析request对象，或去文件上传项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //解析request
            List<FileItem> fileItems = upload.parseRequest(request);
            for(FileItem f : fileItems){
                //是不是普通表单项
                if(f.isFormField()){

                }else{
                    String name = f.getName();
                    String uid = UUID.randomUUID().toString().replace("-", "");
                    name += uid + "_" + name;
                    f.write(new File(path, name));
                    f.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    /**
     * SpringMVC的文件上传
     * @param request
     * @param uploads
     * @return
     */
    @RequestMapping("/uploadFileBySpringMVC")
    public String uploadFileBySpringMVC(HttpServletRequest request,@RequestParam MultipartFile uploads){
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File  file = new File(path);
        //如果文件夹不存在，创建文件夹
        if(!file.exists()){
            file.mkdirs();
        }
        String name = uploads.getOriginalFilename();
        String uid = UUID.randomUUID().toString().replace("-", "");
        name += uid + "_" + name;
        try {
            uploads.transferTo(new File(path, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";

    }
}
