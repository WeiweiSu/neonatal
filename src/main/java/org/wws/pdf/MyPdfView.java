package org.wws.pdf;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;
import org.wws.pojo.HealthQuestion;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
public class MyPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter writer, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
		
		Font secondFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL, new Color(0,0,0));
		Font thirdFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL, Color.BLUE);
		Font fourthFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL, Color.green);
		Font fifthFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL, Color.red);
		
		HealthQuestion question = (HealthQuestion) map.get("question");	
		
		writer.setPageEvent(new Watermark());
		
		PdfPTable table = new PdfPTable(2);
		
		table.addCell(getCell("Type of question:", thirdFont));
		table.addCell(getCell(question.getTitle(), thirdFont));
		
		table.addCell(getCell("Question:", fourthFont));
		table.addCell(getCell(question.getQuestion(), fourthFont));
		
		table.addCell(getCell("Response By Healthcare Provider:", fifthFont));
		table.addCell(getCell(question.getAnswer(), fifthFont));
		
		if(question.getAnsweredbyuser() != null) {
			table.addCell(getCell("Answered By:", secondFont));
			table.addCell(getCell(question.getAnsweredbyuser(), secondFont));
		}
		
		
		
		document.add(table);
		document.close();
		
	}
	
	class Watermark extends PdfPageEventHelper {
		 
        Font FONT = new Font(Font.HELVETICA, 52, Font.BOLD, new GrayColor(0.75f));
 
        public void onEndPage(PdfWriter writer, Document document) {
            ColumnText.showTextAligned(writer.getDirectContentUnder(),
                    Element.ALIGN_CENTER, new Phrase("BABY CENTER COMMUNITY", FONT),
                    297.5f, 421, writer.getPageNumber() % 2 == 1 ? 45 : -45);
        }
    }
	
	private PdfPCell getCell(String p, Font font) {
        Paragraph paragraph = new Paragraph(p, font);
        PdfPCell cell = new PdfPCell(paragraph);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

}
