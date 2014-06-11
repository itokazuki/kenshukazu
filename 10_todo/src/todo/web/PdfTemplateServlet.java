package todo.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class PdfTemplateServlet
 */
@WebServlet("/PdfTemplateServlet.pdf")
public class PdfTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfTemplateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{
			//ドキュメント本体を生成（ページサイズとマージンの設定）
			Document doc = new Document(PageSize.A4, 50,20,270,20);
			//ドキュメントの出力先を定義
			PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());
			//ドキュメントのオープン
			doc.open();

			ServletContext app = this.getServletContext();

			PdfReader reader = new PdfReader(app.getRealPath("./template/Junit.pdf"));

			PdfImportedPage impPage = writer.getImportedPage(reader , 1);

			PdfContentByte pcb = writer.getDirectContent();

			pcb.addTemplate(impPage , 0 ,0);
			Font fnt = new Font(
				BaseFont.createFont("HeiseiKakuGo-W5" , "UniJIS-UCS2-H",
					BaseFont.NOT_EMBEDDED) , 18 ,Font.BOLD);
			doc.add(new Paragraph("こんにちは、iTest!" , fnt));
			doc.close();
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
