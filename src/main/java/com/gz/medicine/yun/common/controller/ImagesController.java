package com.gz.medicine.yun.common.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.TimeUtil;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.ftpUtil.FTPClientPool;
import com.gz.medicine.ftpUtil.Ftp;
import com.gz.medicine.yun.common.bean.FromBlob;
import com.gz.medicine.yun.common.mapper.FromBlobMapper;
import com.gz.medicine.yun.doctor.bean.DTusr;
import com.gz.medicine.yun.doctor.mapper.DTusrMapper;
import com.gz.medicine.yun.doctor.service.DTUsrService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName ImagesController
 * @PackageName com.gz.medicine.yun.common.controller
 * @Description 图片 controller
 * @Data 2017-08-21 10:08
 **/
@RequestMapping("images")
@Controller
public class ImagesController extends ValidateWithException {


    public static final Logger LOGGER = Logger.getLogger(ImagesController.class);

    @Autowired
    FromBlobMapper fromBlobMapper;

    @Autowired
    DTusrMapper dTusrMapper;

    @Autowired
    FTPClientPool ftpclientpool;
    /**
     *
     *@Title getIcons
     *@Description: 把本地的图片以流的形式输出到页面中去
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param
     *@return void
     *@throws
     *@测试地址: localhost:8996/GZ/images/geticons
     */
    @RequestMapping(value="geticons",method = RequestMethod.GET)
    public void getIcons(HttpServletRequest request, HttpServletResponse response){
        OutputStream toClient =null;
        try {
            FileInputStream is = new FileInputStream("G:\\images\\Icon\\valid.png");

            int i = is.available(); // 得到文件大小
            byte data[] = new byte[i];
            is.read(data); // 读数据
            is.close();
            response.setContentType("image/*"); // 设置返回的文件类型
            toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
            toClient.write(data); // 输出数据


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                toClient.close();
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
    }



    /**
     *
     *@Title getImages
     *@Description: 根据imgguid去FORMBLOB中获取图片
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param imageid
     *@return void
     *@throws
     *@测试地址: localhost:8996/GZ/images/getimageid?imageid=269A037ADE14FE02E050AE0AC684ADFB
     */
    @RequestMapping(value="getimageid",method = RequestMethod.GET)
    public void GetImageId(String imageid,HttpServletRequest request, HttpServletResponse response){
        ServletOutputStream out = null;
        if(StringUtils.isNotBlank(imageid)){
            try {

                //根据id去图片表获取数据
                FromBlob fromBlob = fromBlobMapper.selectByPrimaryKey(imageid);
                //获取blob字段
                byte[] contents = fromBlob.getBdata();
                InputStream is = new ByteArrayInputStream(contents);
                response.setContentType("image/*");
                out = response.getOutputStream();
                int len=0;
                byte[]buf=new byte[1024];
                while((len=is.read(buf,0,1024))!=-1){
                    out.write(buf, 0, len);
                }
            } catch (IOException e) {
                LOGGER.error(e);
                e.printStackTrace();
            }finally {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }

            }
        }
    }

    /**
     *
     *@Title getImages
     *@Description: 根据用户表的的imgguid去FORMBLOB中获取图片
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param guid
     *@return void
     *@throws
     *@测试地址: localhost:8996/GZ/images/getimages?guid=269A037ADE14FE02E050AE0AC684ADFB
     */
    @RequestMapping(value="getimages",method = RequestMethod.GET)
    public void getImages(String guid,HttpServletRequest request, HttpServletResponse response){

        ServletOutputStream out = null;

        if(StringUtils.isNotBlank(guid)){

            DTusr dTusr=dTusrMapper.selectByPrimaryKey(guid);
            //根据用户ID去数据库差查,判断是否有数据
            if(dTusr!=null){
                //判断用户的imgguid是否为空,不为空就是有头像
                if(!"".equals(dTusr.getImgguid())&&dTusr.getImgguid()!=null){

                    try {

                        //根据id去图片表获取数据
                        FromBlob fromBlob = fromBlobMapper.selectByPrimaryKey(dTusr.getImgguid());

                        //获取blob字段
                        byte[] contents = fromBlob.getBdata();
                        InputStream is = new ByteArrayInputStream(contents);
                        response.setContentType("image/*");
                        out = response.getOutputStream();
                        int len=0;
                        byte[]buf=new byte[1024];
                        while((len=is.read(buf,0,1024))!=-1){
                            out.write(buf, 0, len);
                        }

                    } catch (IOException e) {
                        LOGGER.error(e);
                        e.printStackTrace();
                    }finally {
                        try {
                            out.flush();
                            out.close();
                        } catch (IOException e) {
                            LOGGER.error(e);
                        }

                    }
            }else{
                    try {
                        //根据id去图片表获取数据
                        FromBlob fromBlob = fromBlobMapper.selectByPrimaryKey("1750C989C347E8E1E050007F01004427");

                        //获取blob字段
                        byte[] contents = fromBlob.getBdata();
                        InputStream is = new ByteArrayInputStream(contents);
                        response.setContentType("image/*");
                        out = response.getOutputStream();
                        int len=0;
                        byte[]buf=new byte[1024];
                        while((len=is.read(buf,0,1024))!=-1){
                            out.write(buf, 0, len);
                        }

                    } catch (IOException e) {
                        LOGGER.error(e);
                        e.printStackTrace();
                    }finally {
                        try {
                            out.flush();
                            out.close();
                        } catch (IOException e) {
                            LOGGER.error(e);
                        }

                    }
             }


        }else {
                try {
                    //根据id去图片表获取数据
                    FromBlob fromBlob = fromBlobMapper.selectByPrimaryKey("1750C989C347E8E1E050007F01004427");

                    //获取blob字段
                    byte[] contents = fromBlob.getBdata();
                    InputStream is = new ByteArrayInputStream(contents);
                    response.setContentType("image/*");
                    out = response.getOutputStream();
                    int len=0;
                    byte[]buf=new byte[1024];
                    while((len=is.read(buf,0,1024))!=-1){
                        out.write(buf, 0, len);
                    }

                } catch (IOException e) {
                    LOGGER.error(e);
                    e.printStackTrace();
                }finally {
                    try {
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        LOGGER.error(e);
                    }

                }
            }
    }


    }


    /**
     *
     *@Title fileupload
     *@Description: 往FTP中上传单个图片
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param file
     *@return void
     *@throws
     *@测试地址: localhost:8996/GZ/images/fileupload
     */
    @RequestMapping(value="fileupload",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult fileUpload(@RequestParam("file") MultipartFile file){
        String filePath=null;
        StringBuilder fileName=null;
        SimpleResult simpleResult=null;
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                    String name = file.getOriginalFilename();
                    filePath = PropertyUtil.getPropery("ftp.orderfilePath");
                    fileName = getFileName(name);
                    //上传至ftp服务器，并替换文件名称
                    uploadFile(file, filePath, fileName.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        simpleResult=SimpleResult.success();
        //simpleResult.putData("imagepath",filePath+"/"+fileName.toString());
        simpleResult.putData("imagepath",fileName.toString()+"");
        return simpleResult;
    }


    @RequestMapping("fileuploads")
    public String filesUploads(@RequestParam("files") MultipartFile[] files) {
        String filePath=null;
        String[] stringList ={};
        StringBuilder fileName=null;

        try {
            //判断file数组不能为空并且长度大于0
            if(files!=null&&files.length>0){
                stringList=new String[files.length];
                //循环获取file数组中得文件
                for(int i = 0;i<files.length;i++){
                    MultipartFile file = files[i];
                    //保存文件
                    String name = file.getOriginalFilename();
                    filePath = PropertyUtil.getPropery("ftp.filePath");
                    fileName = getFileName(name);
                    stringList[i]=fileName.toString();
                    //上传至ftp服务器，并替换文件名称
                    uploadFile(file, filePath, fileName.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // 重定向
        return new String();
    }


    private void uploadFile(MultipartFile file, String filePath, String name) throws Exception {
        Ftp f = ftpclientpool.borrowObject();

        f.uploadFile(file.getInputStream(), name, filePath);
        ftpclientpool.returnObject(f);
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

}
