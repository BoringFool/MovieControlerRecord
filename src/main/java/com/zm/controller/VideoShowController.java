package com.zm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.service.FileAttrService;

@Controller
@RequestMapping("/video")
public class VideoShowController {
    
    private static Logger logger = Logger.getLogger(VideoShowController.class);
    
    @Resource
    FileAttrService fileService;

    /**    
     * @Description: 调用播放器播放视频 
     * @Author ZhaoMao
     * @Date 2019年6月10日 
     * @param: @param name  视频文件的路径 
     * @return: void      
     */
    @RequestMapping("show")
    public void show(@RequestParam("name") String name) {
        openExe(name);
    }
    
    /**    
     * @Description: 调用播放器播放视频，看是否能获得播放器
     * 关闭时，视频的播放进度等信息。 
     * @Author ZhaoMao
     * @Date 2019年6月10日 
     * @param: @param name  视频文件的路径 
     * @return: void      
     */
    @RequestMapping("showdetail")
    public void showDetail(@RequestParam("name") String name) {
        infoBack();
    }
    
    
    /**    
     * @Description: 打开本地播放器并播放视频 
     * @Author ZhaoMao
     * @Date 2019年6月10日 
     * @param: @param file  视频文件的路径
     * @return: void      
     */
    public static void openExe(String file) {
        Runtime rn = Runtime.getRuntime();
        StringBuffer player = new StringBuffer("D:\\XMP\\V5.4.4.6458\\Bin\\XMP.exe ");//结尾空格是必须的。
        player.append(file);
        try {
            //D:\\XMP\\V5.4.4.6458\\Bin\\XMP.exe C:\\Users\\Borgni\\Desktop\\视频\\test.mp4
            rn.exec(player.toString());
        } catch (Exception e) {
            logger.error("调用播放器失败", e);
        }
    }
    
    /**    
     * @Description: 打开本地播放器并播放视频,获得视频的返回信息 
     * @Author ZhaoMao
     * @Date 2019年6月10日 
     * @param: @param file  视频文件的路径
     * @return: void      
     */
    public static void infoBack() {
        Runtime rn = Runtime.getRuntime();
        Process p = null;
        InputStream in = null;
        FileOutputStream out = null;
        
        File f = new File("C:\\Users\\Borgni\\Desktop\\视频\\log.txt");
        
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.error("创建日志记录文件失败", e);
            }
        }
        
        StringBuffer player = new StringBuffer("D:\\XMP\\V5.4.4.6458\\Bin\\XMP.exe ");//结尾空格是必须的。
        player.append("C:\\Users\\Borgni\\Desktop\\视频\\test.mp4");
        try {
            p = rn.exec(player.toString());
            int val = p.exitValue();
            logger.debug("子进程结束时，返回的值：" + val);
            if(!p.isAlive()) {
              in = p.getInputStream(); 
              out = new FileOutputStream(f, true);
              
              int ret = 0;
              byte[] b = new byte[1024];
              while((ret = in.read(b)) != -1) {
                  out.write(b, 0, ret);
              }
            }
        } catch (Exception e) {
            logger.error("调用播放器失败", e);
        }finally {
            try {
                if(out != null) {
                    out.close();
                }
                
                if(in != null) {
                    in.close();
                }
            } catch (IOException e) {
               logger.error("关闭输入输出流失败", e);
            }
        }
    }
    
    
    /**    
     * @Description: 扫描U盘目录列表 
     * @Author ZhaoMao
     * @Date 2019年6月19日 
     * @param: @return      
     * @return: List<String>      
     * @throws   
     */
    @RequestMapping("/filelist")
    @ResponseBody
    public Object listFile(HttpServletResponse res){
        //获取当前系统文件类型,用以获得U盘的卷标，从而获得盘符
        FileSystemView fileSys=FileSystemView.getFileSystemView(); 
        File[] root = File.listRoots();
        
        for(File f : root) {
            String disname = fileSys.getSystemDisplayName(f);
            if("".equals(disname))
                continue;
            
            System.out.println("=============="+disname+"=============");
            String cut = disname.substring(0, disname.indexOf("("));
            if("U ".equals(cut)) {
                String Uname = disname.substring(disname.indexOf("(")+1,disname.length()-1);
                return fileService.scanFile(Uname);
            }
        }
       
        return "Fail to find Udisk!";
    }
}