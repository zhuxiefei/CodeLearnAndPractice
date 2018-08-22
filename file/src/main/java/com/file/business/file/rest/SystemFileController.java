package com.file.business.file.rest;


import basic.common.core.id.IdUtil;
import com.beite.tools.utils.FileUtil;
import com.beite.tools.utils.PropertiesUtil;
import com.file.business.file.model.SystemFile;
import com.file.business.file.service.SystemFileOneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhuxiefei
 * @date 2018/8/21 11:22
 */
@RestController
@Api(value = "fileUploadAndDownload",description = "文件上传与下载")
@RequestMapping(value = "/pm/web/file")
public class SystemFileController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Autowired
    private SystemFileOneService systemFileOneService;

    @ApiOperation(value = "上传文件", notes = "上传文件")
    @RequestMapping(value = "/filepload", method = RequestMethod.POST)
    @ResponseBody
    public SystemFile fileupload(@RequestBody MultipartFile multipartFile, HttpServletRequest request) throws Exception {
        int fileMaxSize = 10*1024*1024;
        if (multipartFile.getSize()>fileMaxSize){
            //throw new GlobalException("DC001");
            throw new Exception("文件大小超过20M");
        }
        int type = FileUtil.getFileType(multipartFile);
        if (type!=3){
            throw new Exception("格式不正确，请上传格式为pdf doc docx的文档");
        }
        String fileUrl = FileUtil.uploadFile(multipartFile , "document");
        String fileName = multipartFile.getOriginalFilename();
        SystemFile systemFile = new SystemFile();
        systemFile.setFileId(IdUtil.getId()+"");
        systemFile.setFileName(fileName);
        systemFile.setFileUrl(fileUrl);
        systemFile.setCreateTime(new Date());
        systemFile.setFileType(5);
        systemFileOneService.insertSystemFile(systemFile);
        return systemFile;
    }

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @RequestMapping(value = "/pictureupload", method = RequestMethod.POST)
    @ResponseBody
    public SystemFile pictureUpload(@RequestBody MultipartFile multipartFile,HttpServletRequest request) throws Exception {

        String a = PropertiesUtil.getProperty("fileMaxSize");
        if(multipartFile.getSize()>Integer.parseInt(a)){
            throw new Exception("上传的文件大小超出限制");
        }
        String fileUrl = FileUtil.uploadFile(multipartFile , "online");
        Date createTime = new Date();
        String fileName = multipartFile.getOriginalFilename();
        SystemFile systemFile = new SystemFile();
        systemFile.setFileId(IdUtil.getId()+"");
        systemFile.setFileName(fileName);
        systemFile.setFileUrl(fileUrl);
        systemFile.setCreateTime(createTime);
        int number = FileUtil.getFileType(multipartFile);
        if(number==1){
            systemFile.setFileType(2);
        }else if(number==2){
            systemFile.setFileType(1);
            FileUtil.saveThumbnail(fileUrl);
        }else{
            throw new Exception("文件格式不正确");
        }

        systemFileOneService.insertSystemFile(systemFile);
        return systemFile;

    }
    /*@ApiOperation(value = "取消上传图片", notes = "取消上传图片")
    @RequestMapping(value = "/deletefile", method = RequestMethod.GET)
    @ResponseBody
    public Response<Boolean> deletefile(@RequestParam String fileId) throws Exception {
        boolean a = systemFileService.deleteSystemFileById(fileId);
        return new Response<Boolean>(a);
    }*/





}