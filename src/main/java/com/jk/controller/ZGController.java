package com.jk.controller;

import com.jk.bean.Exprent;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.ZG;
import com.jk.service.ZGService;
import com.jk.utils.OssUpFileUtil;
import com.jk.utils.PoiExportExcel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("zhuanjia")
public class ZGController {

    @Autowired
    ZGService zgService;

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping("queryZG")
    public SendPage queryZG(ReceivePage receivePage){
        return zgService.queryZG(receivePage);
    }

    /**
     * 回显
     */
    @ResponseBody
    @RequestMapping("queryZGById")
    public ZG queryZGById(String id){
        return zgService.queryZGById(id);
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("updateZG")
    public void updateZG(ZG zg){
        zgService.updateZG(zg);
    }

    /**
     * 删除(批量删)
     */
    @ResponseBody
    @RequestMapping("deleteZG")
    public void deleteZG(String ids){
        zgService.deleteZG(ids);
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping("addZG")
    public void addZG(ZG zg){
        if(zg.getDt_qw()==null){
            zg.setDt_qw(0);
        }
        zgService.addZG(zg);
    }

   /**
     * for循环赋值
     *//*
    @ResponseBody
    @RequestMapping("addZG2")
    public void addZG2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 0;
                int add = 111111;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 20000;
                int add = 222222;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 40000;
                int add = 333333;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 60000;
                int add = 444444;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 80000;
                int add = 555555;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 100000;
                int add = 666666;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 120000;
                int add = 777777;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 140000;
                int add = 888888;//线程编号
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num);
                    System.out.println("线程编号==="+add); }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 180000;
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num); }
            }
        }).start(); new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 20000L;
                int num = 200000;
                for (long i = 0; i < count; i++) {
                    num++;  qwe(num); }
            }
        }).start();
    }
    public void qwe(int num){
        ZG zg = new ZG();
        zg.setDt_name("name"+num);
        zg.setDt_zc("zc"+num);
        zg.setDt_addr("addr"+num);
        zg.setDt_img("img"+num);
        zg.setDt_jj("jj"+num);
        zg.setDt_modle("model"+num);
        zg.setDt_level(5);
        zg.setDt_qw(1);
        addZG(zg);
    }*/


    /**
     * 跳页面
     */
    @RequestMapping("toView")
    public String toView(String viewname){
        return viewname;
    }

    /**
     * 上传文件
     */
    String filename = "";
    @ResponseBody
    @PostMapping("toUploadBlog")
    public String toUploadBlog(@RequestParam("file") MultipartFile file){
        Map<String, Object> stringObjectMap = OssUpFileUtil.uploadFile(file);
        System.out.println(stringObjectMap);
        String count = "";
        for (String key : stringObjectMap.keySet()) {
            Object o = stringObjectMap.get(key);
            System.out.println("key: " + key + " value: " + o);
            if(key=="url"){
                count+=o;
                filename = count;
            } }
        return count;
    }
    /**
     * POI导出所有数据
     */
    @ResponseBody
    @RequestMapping("deriveAllData")
    public String deriveAllData(HttpServletRequest request, HttpServletResponse response){

        List<Exprent>  psgList = zgService.getAllData();
        String fileName = "sad.xls";
        response.reset();// 清空response
        response.addHeader("Content-Disposition", "attachment;filename="+fileName);// 设置response的Header
        response.setContentType("application/octet-stream");
        PoiExportExcel.PoiWriteExcel("工作薄",psgList,request,response);
        return "1";
    }
    /**
     * POI导出
     */
    @ResponseBody
    @RequestMapping("poiDerive")
    public String poiDerive(String dis,HttpServletResponse response) throws IOException {

        /////获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        //格式化时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        String format = simpleDateFormat.format(new Date());

        String resultUrl = com.getPath() + "//" + format + ".xls";     //文件路径

        List<Exprent> data = zgService.poiDerive(dis);

        HSSFWorkbook workbook  = new HSSFWorkbook(); //创建一个文档

        HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)

        String[] headers = {"主键id", "专家名字", "职称", "地址", "图片地址", "简介", "合作项目", "等级","权威"};
        HSSFRow row = sheet.createRow(0);// 创建行,从0开始
        int a = 0;
        for (String header : headers) {
            row.createCell(a).setCellValue(header);
            a++;
        }
        int index = 0;
        for (Exprent datum : data) {
            index++; //上面已经有0了  这里从1开始 就是从第二行开始
            row = sheet.createRow(index);
            row.createCell(0).setCellValue(datum.getId());
            row.createCell(1).setCellValue(datum.getDt_name());
            row.createCell(2).setCellValue(datum.getDt_zc());
            row.createCell(3).setCellValue(datum.getDt_addr());
            row.createCell(4).setCellValue(datum.getDt_img());
            row.createCell(5).setCellValue(datum.getDt_jj());
            row.createCell(6).setCellValue(datum.getDt_modle());
            row.createCell(7).setCellValue(datum.getDt_level());
            row.createCell(8).setCellValue(datum.getDt_qw());
        }
        FileOutputStream out = new FileOutputStream(resultUrl); //表格保存位置

        workbook.write(out);//保存Excel文件
        out.close();//关闭文件流
        String[] split = resultUrl.split("//");
        String s = split[1];

        System.out.println(s);
        return s;
    }

    @RequestMapping("download")
    public void download(String filename, HttpServletResponse response) {
        /////获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        String path = com.getPath();
        String resultUrl =  path +"\\"+filename;
        String filePath = resultUrl;//所要下载的文件路径，从数据库中查询得到，当然也可以直接写文件路径，如：C:\\Users\\Administrator\\Desktop\\csv\\号码_utf8_100.csv
        try {
            File file = new File(filePath);
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);//得到文件名
            fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");//把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
            response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
            response.addHeader("Content-Disposition", "attachment;filename="+fileName);//Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
            String len = String.valueOf(file.length());
            response.setHeader("Content-Length", len);//设置内容长度
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(file);
            byte[] b = new byte[1024];
            int n;
            while((n=in.read(b))!=-1){
                out.write(b, 0, n);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}