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
		//��ȡ����
		DriverService service = new DriverService();
		List<Driver> list = service.getAllDriverInfoList();
					
		try {
			//OutputStream os = response.getOutputStream();// ȡ�������
			response.reset();// ��������
			// Ӣ���ļ�ͷ
			// response.setHeader("Content-disposition",
			// "attachment; filename=sbxx.xls");// �趨����ļ�ͷ
			// response.setContentType("application/msexcel");// �����������

			// �����ļ�ͷ
			//response.setContentType("application/msexcel;charset=utf-8");// �����������
			//String filenames = "˾����Ϣ��.xls";
			//response.addHeader("Content-Disposition","attachment;filename=\""+ new String(filenames.getBytes(), "iso8859-1") + "\""); // �趨����ļ�ͷ

			WritableWorkbook wbook = Workbook.createWorkbook(new File("D:/Tomcat 7.0/webapps/myproject/download/DriverInfo.xls")); // ����excel�ļ�             linux/usr/local/tomcat/apache-tomcat-7.0.55/webapps/myproject/download/DriverInfo.xls
			String tmptitle = "˾����Ϣ��"; // ����
			WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet����

			// ����excel����
			WritableFont wfont = new WritableFont(WritableFont.ARIAL, 20,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
			WritableCellFormat wcfFC = new WritableCellFormat(wfont);
//			wcfFC.setBackground(Colour.AQUA);
			wsheet.addCell(new Label(5, 0, tmptitle, wcfFC));
//			wfont = new jxl.write.WritableFont(WritableFont.ARIAL, 14,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
//			wcfFC = new WritableCellFormat(wfont);
			
			//�п��
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
			// ��ʼ������������ A-0 B-1 C-2
			// ����
			wsheet.addCell(new Label(0, 1, "����"));// ����
			wsheet.addCell(new Label(1, 1, "����"));
			wsheet.addCell(new Label(2, 1, "�Ա�"));
			wsheet.addCell(new Label(3, 1, "����"));
			wsheet.addCell(new Label(4, 1, "���֤��"));
			wsheet.addCell(new Label(5, 1, "��ʻ֤��"));
			wsheet.addCell(new Label(6, 1, "�Ļ��̶�"));
			wsheet.addCell(new Label(7, 1, "�̻�"));
			wsheet.addCell(new Label(8, 1, "�ֻ�"));
			wsheet.addCell(new Label(9, 1, "סַ"));
			wsheet.addCell(new Label(10, 1, "����˾ʱ��"));
			wsheet.addCell(new Label(11, 1, "��ͬ��ʼ����"));

			// ����

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

			// �����������ɽ���
			wbook.write(); // д���ļ�
			wbook.close();
			//os.close(); // �ر���

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������EXCEL�Ĺ����г��ִ��󣬴���ԭ��" + e.toString());

		}
		SmartUpload su=new SmartUpload();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true,8192, true);
	    su.initialize(pageContext);  
	    su.setAllowedFilesList("xls");
	    su.setContentDisposition(null);//��ֹ��������ļ� ֻ������  
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
