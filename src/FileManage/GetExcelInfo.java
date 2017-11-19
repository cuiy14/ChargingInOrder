package FileManage;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;
import java.util.LinkedList;

import Tests.constants;
import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException;  
public class GetExcelInfo {  
    public static void main(String[] args) throws BiffException, IOException {  
        // GetExcelInfo obj = new GetExcelInfo();  
        // File file = new File("C:/Users/Thinkpad/Desktop/有序充电PPT/模拟数据/STLF_DATA_IN_1.xls");  
        // obj.readExcel(file); 
        String path=constants.path;
        LinkedList<Double> val=GetExcelInfo.readLine(path, 0, 2);
//        System.out.println(val.size());
        for(int iter=0;iter!=val.size();iter++)
        	System.out.println(String.valueOf(val.get(iter)));
    }  
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象  
    public void readExcel(File file) {  
        try {  
            // 创建输入流，读取Excel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            Workbook wb = Workbook.getWorkbook(is);  
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
                Sheet sheet = wb.getSheet(index);  
                // sheet.getRows()返回该页的总行数  
                for (int i = 0; i < sheet.getRows(); i++) {  
                    // sheet.getColumns()返回该页的总列数  
                    for (int j = 0; j < sheet.getColumns(); j++) {  
                        String cellinfo = sheet.getCell(j, i).getContents();  
                        System.out.println(cellinfo);  
                    }  
                }  
            } 
            is.close(); 
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (BiffException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }      
    } ;
    // read the specific line from sample file
    public static LinkedList<Double> readLine(String path, int sheetIndex, int line) throws BiffException, IOException{
    	File file = new File(path);
    	LinkedList<Double> val=new LinkedList<Double>();
    	try {
			InputStream iStream=new FileInputStream(file.getAbsolutePath());
            Workbook wb=Workbook.getWorkbook(iStream);
            Sheet sheet=wb.getSheet(sheetIndex);   
            for(int j=0;j<sheet.getColumns();j++)
                val.add((Double)Double.parseDouble(sheet.getCell(j,line).getContents()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return val;
    }
}  



// read line实现excel读取；在datagenerator中实现数据的改造（当前时段的检测，在 TimeTool中初始化一个static day 用来记录系统运行天数），tableSequence直接利用其初始化
