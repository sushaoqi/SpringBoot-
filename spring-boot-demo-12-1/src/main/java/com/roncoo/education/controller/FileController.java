
package com.roncoo.education.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * spring-boot-demo-12-1
 * 
 * @author wujing
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	// 文件上传代码
	@RequestMapping(value = "upload")
	@ResponseBody
	public String upload(@RequestParam("roncooFile") MultipartFile file) {
		if (file.isEmpty()) {
			return "文件为空";
		}

		// 获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);

		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);

		// 文件上传路径
		String filePath = "d:/roncoo/ttt/";

		// 解决中文问题，liunx下中文路径，图片显示问题
		fileName = UUID.randomUUID() + suffixName;

		File dest = new File(filePath + fileName);

		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}

		try {
			file.transferTo(dest);
			return "上传成功";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}
     
	
	//文件下载
	 @RequestMapping(value = "/download")
	    @ResponseBody
	        public String download(HttpServletResponse response) throws Exception {
	            BufferedInputStream bis = null;
	            BufferedOutputStream bos = null;
	            //获取下载文件露肩
	            String downLoadPath = "D:\\roncoo\\ttt\\65e920e9-ec7e-4d09-b32a-7ec491a763bc.jpg";
	 
	            /*response.setHeader("content-type", "application/octet-stream");
	            //获取文件的长度
	            long fileLength = new File(downLoadPath).length();
	            //设置文件输出类型
	            response.setContentType("application/octet-stream");
	            //设置输出长度
	            response.setHeader("Content-Length", String.valueOf(fileLength));*/
	        /********************************************************************/
	            //获取输入流
	            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
	            //输出流
	            bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\roncoo\\ttt\\1.jpg")));
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	            //关闭流
	            bis.close();
	            bos.close();
	 
	        return "下载成功";
	    }
  
     //文件下载
	 @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
	    @ResponseBody
	    public String handleFileUpload(HttpServletRequest request){
	        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
	        MultipartFile file = null;
	        BufferedOutputStream stream = null;
	        for (int i =0; i< files.size(); ++i) {
	            file = files.get(i);
	            if (!file.isEmpty()) {
	                try {
	                   BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\roncoo\\ttt\\" + file.getOriginalFilename())));
	                   bufferedOutputStream.write(file.getBytes());
	                   bufferedOutputStream.flush();
	                   bufferedOutputStream.close();
	                } catch (Exception e) {
	                    return "You failed to upload " + i + " => " + e.getMessage();
	                }
	            } else {
	                return "You failed to upload " + i + " because the file was empty.";
	            }
	        }
	        return "上传成功";
	    }
}
