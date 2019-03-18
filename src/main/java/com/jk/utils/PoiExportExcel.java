package com.jk.utils;

import com.jk.bean.Exprent;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PoiExportExcel {

    /**
     * 导出数据到多个sheet
     * @param title
     * @param list
     * @param //os
     * add by bcao 2015-8-13
     */
    @SuppressWarnings({ "deprecation", "rawtypes", "unused", "unchecked" })
    public static void PoiWriteExcel(String title,List<Exprent> list,HttpServletRequest request,HttpServletResponse response){
        OutputStream os=null;
        try{
            int sheetNum=1;//工作薄sheet编号
            int bodyRowCount=1;//正文内容行号
            int currentRowCount=1;//当前的行号
            int perPageNum = 20100;//每个工作薄显示50000条数据
            os = new BufferedOutputStream(response.getOutputStream());//输出流
            HSSFWorkbook workbook = new HSSFWorkbook();//创建excel
            HSSFSheet sheet = workbook.createSheet(title+sheetNum);//创建一个工作薄
            setSheetColumn(sheet);//设置工作薄列宽
            HSSFRow row = null;//创建一行
            HSSFCell cell = null;//每个单元格

            HSSFCellStyle titleCellStyle = createTitleCellStyle(workbook);

            writeTitleContent(sheet,titleCellStyle);//写入标题

            //第二行开始写入数据
            //创建的表格样式
            HSSFCellStyle bodyCellStyle = createBodyCellStyle(workbook);
            HSSFCellStyle dateBobyCellStyle = createDateBodyCellStyle(workbook);

            for(int i=0;i<list.size();i++){
                //正文内容
                row = sheet.createRow(bodyRowCount);
                //第二行写开始写入正文内容
                cell = row.createCell((short)0);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(currentRowCount); //序号
                cell = row.createCell((short)1);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(list.get(i).getDt_name());    //专家名字
                cell = row.createCell((short)2);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(list.get(i).getDt_zc());    //职称
                cell = row.createCell((short)3);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(list.get(i).getDt_img());     //图片
                cell = row.createCell((short)4);
                cell.setCellStyle(dateBobyCellStyle);
                cell.setCellValue(list.get(i).getDt_addr());     //地址
                cell = row.createCell((short)5);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(list.get(i).getDt_jj());      //简介
                cell = row.createCell((short)6);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(list.get(i).getDt_modle());   //参与项目
                cell = row.createCell((short)7);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(list.get(i).getDt_level());   //等级
                cell = row.createCell((short)8);
                cell.setCellStyle(bodyCellStyle);
                cell.setCellValue(list.get(i).getDt_qw());      //权威
                cell = row.createCell((short)9);
                cell.setCellStyle(bodyCellStyle);
                if(currentRowCount % perPageNum == 0){//每个工作薄显示50000条数据
                    sheet=null;
                    sheetNum++;//工作薄编号递增1
                    sheet = workbook.createSheet(title+sheetNum);//创建一个新的工作薄
                    setSheetColumn(sheet);//设置工作薄列宽
                    bodyRowCount = 0;//正文内容行号置位为0
                    writeTitleContent(sheet,titleCellStyle);//写入标题
                }
                bodyRowCount++;//正文内容行号递增1
                currentRowCount++;//当前行号递增1
            }
            //CookieUtil.remove(request,response,"exporting");//删除exporting cookie
            workbook.write(os);
            os.flush();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    /**
     * 设置正文单元样式
     * @param //workbook
     * @return
     */
    public static HSSFCellStyle createBodyCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 8);
        font.setFontName(HSSFFont.FONT_ARIAL);//设置标题字体
        cellStyle.setFont(font);
        cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        return cellStyle;
    }
    /**
     * 设置正文单元时间样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle createDateBodyCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 8);
        font.setFontName(HSSFFont.FONT_ARIAL);//设置标题字体
        cellStyle.setFont(font);
        cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        HSSFDataFormat format= workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("yyyy-mm-dd"));
        return cellStyle;
    }

    /**
     * 设置标题单元样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle createTitleCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short) 8);
        font.setFontName(HSSFFont.FONT_ARIAL);//设置标题字体
        cellStyle.setFont(font);
        cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);//设置列标题样式
        cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);// 设置背景色
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        return cellStyle;
    }
    /**
     * 写入标题行
     * @param //workbook
     * @return
     */
    public static void writeTitleContent (HSSFSheet sheet,HSSFCellStyle cellStyle){
        HSSFRow row = null;
        HSSFCell cell = null;
        //标题
        row = sheet.createRow(0);
        //第一行写入标题行
        cell = row.createCell((short)0);//序号
        cell.setCellStyle(cellStyle);
        cell.setCellValue("序号");
        cell = row.createCell((short)1);//专家名字
        cell.setCellStyle(cellStyle);
        cell.setCellValue("专家名字");
        cell = row.createCell((short)2);//职称
        cell.setCellStyle(cellStyle);
        cell.setCellValue("职称");
        cell = row.createCell((short)3);//图片
        cell.setCellStyle(cellStyle);
        cell.setCellValue("图片");
        cell = row.createCell((short)4);//地址
        cell.setCellStyle(cellStyle);
        cell.setCellValue("地址");
        cell = row.createCell((short)5);//简介
        cell.setCellStyle(cellStyle);
        cell.setCellValue("简介");
        cell = row.createCell((short)6);//参与项目
        cell.setCellStyle(cellStyle);
        cell.setCellValue("参与项目");
        cell = row.createCell((short)7);//等级
        cell.setCellStyle(cellStyle);
        cell.setCellValue("等级");
        cell = row.createCell((short)8);//权威
        cell.setCellStyle(cellStyle);
        cell.setCellValue("权威");
    }
    public static void setSheetColumn(HSSFSheet sheet){
        sheet.setColumnWidth((short) 2, (short) 3200);//设置手机号列宽
        sheet.setColumnWidth((short) 4, (short) 3200);//设置航班日期列宽
        sheet.setColumnWidth((short) 7, (short) 5250);//设置电子票号列宽
        sheet.setColumnWidth((short) 8, (short) 6250);//设置证件号列宽
    }

}
