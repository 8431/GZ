/**
 * projectName: GZ
 * fileName: FileUploadController.java
 * packageName: com.gz.medicine.yun.common.controller
 * date: 2018-02-27 14:43
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.yun.common.controller;

import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.TimeUtil;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.ftpUtil.FTPClientPool;
import com.gz.medicine.ftpUtil.Ftp;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @version: V1.0
 * @author: fendo
 * @className: FileUploadController
 * @packageName: com.gz.medicine.yun.common.controller
 * @description: 文件上传
 * @data: 2018-02-27 14:43
 **/
@RequestMapping("fileupload")
@Controller
public class FileUploadController extends ValidateWithException {

    @Autowired
    FTPClientPool ftpclientpool;

    /**
     * @param file
     * @return void
     * @throws
     * @Title fileupload
     * @Description: 往FTP中上传文件
     * @Author fendo
     * @Date 2017年8月17日 上午10:52
     * @测试地址: localhost:8996/GZ/images/fileupload
     */
    @RequestMapping(value = "fileupload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    //public SimpleResult fileUpload(@RequestParam("uerid") String userid, @RequestParam("file") MultipartFile file) {
    public SimpleResult fileUpload(@RequestParam("file") MultipartFile file) {
        String filePath = null;
        StringBuilder fileName = null;
        SimpleResult simpleResult = null;
        // 判断文件是否为空
        String name = file.getOriginalFilename();
        filePath = PropertyUtil.getPropery("ftp.allfilePath");
        try {
            fileName = getFileName(name);
            //上传至ftp服务器，并替换文件名称
            uploadFile(file, filePath, fileName.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        simpleResult = SimpleResult.success();
        simpleResult.putData("filepath", fileName.toString() + "");
        return simpleResult;
    }

    private StringBuilder getFileName(String name) throws Exception {
        StringBuilder sb = new StringBuilder(name);
        String gs = sb.substring(sb.lastIndexOf("."));
        StringBuilder fileName = new StringBuilder();
        fileName.append(TimeUtil.getCurrentTimeNumByDay());
        String uuid = (int) ((Math.random() * 9 + 1) * 10000000) + "";
        fileName.append(uuid);
        fileName.append(gs);
        return fileName;
    }

    private void uploadFile(MultipartFile file, String filePath, String name) throws Exception {
        Ftp f = ftpclientpool.borrowObject();
        f.uploadFile(file.getInputStream(), name, filePath);
        ftpclientpool.returnObject(f);
    }

    /**
     * 创建目录(有则切换目录，没有则创建目录)
     * @param dir
     * @return
     */
    public boolean createDir(String dir,FTPClient ftp){
        if(isNullOrEmpty(dir)){
            return true;
        }
        String d;
        try {
            //目录编码，解决中文路径问题
            d = new String(dir.toString().getBytes("GBK"),"iso-8859-1");
            //尝试切入目录
            if(ftp.changeWorkingDirectory(d)){
                return true;
            }
            dir = trimStart(dir, "/");
            dir = trimEnd(dir, "/");
            String[] arr =  dir.split("/");
            StringBuffer sbfDir=new StringBuffer();
            //循环生成子目录
            for(String s : arr){
                sbfDir.append("/");
                sbfDir.append(s);
                //目录编码，解决中文路径问题
                d = new String(sbfDir.toString().getBytes("GBK"),"iso-8859-1");
                //尝试切入目录
                if(ftp.changeWorkingDirectory(d)){
                    continue;
                }
                if(!ftp.makeDirectory(d)){
                    System.out.println("[失败]ftp创建目录："+sbfDir.toString());
                    return false;
                }
                System.out.println("[成功]创建ftp目录："+sbfDir.toString());
            }
            //将目录切换至指定路径
            return ftp.changeWorkingDirectory(d);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除起始字符
     * @param str
     * @return
     */
    public static String trimStart(String str,String trim){
        if(str==null) {
            return null;
        }
        return str.replaceAll("^("+trim+")+", "");
    }

    /**
     * 字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str){
        return str==null || str.trim().isEmpty();
    }

    /**
     * 删除末尾字符
     * @param str
     * @return
     */
    public static String trimEnd(String str,String trim){
        if(str==null){
            return null;
        }
        return str.replaceAll("("+trim+")+$", "");
    }

}