package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspFactory;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import service.DriverService;
import dao.Driver;

/**
 * Servlet implementation class ExportDriverInfo
 */
public class ExportDriverInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportDriverInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//获取数据
		DriverService service = new DriverService();
		List<Driver> list = service.getAllDriverInfoList();
					
		try {
			//OutputStream os = response.getOutputStream();// 取得输出流
			response.reset();// 清空输出流
			// 英文文件头
			// response.setHeader("Content-disposition",
			// "attachment; filename=sbxx.xls");// 设定输出文件头
			// response.setContentType("application/msexcel");// 定义输出类型

			// 中文文件头
			//response.setContentType("application/msexcel;charset=utf-8");// 定义输出类型
			//String filenames = "司机信息表.xls";
			//response.addHeader("Content-Disposition","attachment;filename=\""+ new String(filenames.getBytes(), "iso8859-1") + "\""); // 设定输出文件头

			WritableWorkbook wbook = Workbook.createWorkbook(new File("D:/Tomcat 7.0/webapps/myproject/download/DriverInfo.xls")); // 建立excel文件             linux/usr/local/tomcat/apache-tomcat-7.0.55/webapps/myproject/download/DriverInfo.xls
			String tmptitle = "司机信息表"; // 标题
			WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称

			// 设置excel标题
			WritableFont wfont = new WritableFont(WritableFont.ARIAL, 20,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
			WritableCellFormat wcfFC = new WritableCellFormat(wfont);
//			wcfFC.setBackground(Colour.AQUA);
			wsheet.addCell(new Label(5, 0, tmptitle, wcfFC));
//			wfont = new jxl.write.WritableFont(WritableFont.ARIAL, 14,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
//			wcfFC = new WritableCellFormat(wfont);
			
			//列宽度
			wsheet.setColumnView(0, 5);
			wsheet.setColumnView(1, 8);
			wsheet.setColumnView(2, 5);
			wsheet.setColumnView(3, 5);
			wsheet.setColumnView(4, 20);
			wsheet.setColumnView(5, 20);
			wsheet.setColumnView(6, 8);
			wsheet.setColumnView(7, 14);
			wsheet.setColumnView(8, 13);
			wsheet.setColumnView(9, 6);
			wsheet.setColumnView(10, 11);
			wsheet.setColumnView(11, 21);
			// 开始生成主体内容 A-0 B-1 C-2
			// 列名
			wsheet.addCell(new Label(0, 1, "工号"));// 列名
			wsheet.addCell(new Label(1, 1, "姓名"));
			wsheet.addCell(new Label(2, 1, "性别"));
			wsheet.addCell(new Label(3, 1, "年龄"));
			wsheet.addCell(new Label(4, 1, "身份证号"));
			wsheet.addCell(new Label(5, 1, "驾驶证号"));
			wsheet.addCell(new Label(6, 1, "文化程度"));
			wsheet.addCell(new Label(7, 1, "固话"));
			wsheet.addCell(new Label(8, 1, "手机"));
			wsheet.addCell(new Label(9, 1, "住址"));
			wsheet.addCell(new Label(10, 1, "进公司时间"));
			wsheet.addCell(new Label(11, 1, "合同起始日期"));

			// 数据

			for (int i = 0; i < list.size(); i++) {
				Driver driver = (Driver) list.get(i);
				wsheet.addCell(new Label(0, i + 2, String.valueOf((driver.getId()))));
				wsheet.addCell(new Label(1, i + 2, driver.getName()));
				wsheet.addCell(new Label(2, i + 2, driver.getSex()));
				wsheet.addCell(new Label(3, i + 2, String.valueOf(driver.getAge())));
				wsheet.addCell(new Label(4, i + 2, driver.getIdCard()));
				wsheet.addCell(new Label(5, i + 2, driver.getDriverNum()));
				wsheet.addCell(new Label(6, i + 2, driver.getEducation()));
				wsheet.addCell(new Label(7, i + 2, driver.getTel()));
				wsheet.addCell(new Label(8, i + 2, driver.getPhone()));
				wsheet.addCell(new Label(9, i + 2, driver.getAddress()));
				wsheet.addCell(new Label(10, i + 2, driver.getHireTime()));
				wsheet.addCell(new Label(11, i + 2, driver.getStartTime()));
							
			}

			// 主体内容生成结束
			wbook.write(); // 写入文件
			wbook.close();
			//os.close(); // 关闭流

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("在输出到EXCEL的过程中出现错误，错误原因：" + e.toString());

		}
		SmartUpload su=new SmartUpload();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true,8192, true);
	    su.initialize(pageContext);  
	    su.setAllowedFilesList("xls");
	    su.setContentDisposition(null);//禁止浏览器打开文件 只能下载  
	    try {
			su.downloadFile("download/DriverInfo.xls");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		//request.getRequestDispatcher("ShowAllDriverInfo").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
