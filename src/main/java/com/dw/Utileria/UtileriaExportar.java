package com.dw.Utileria;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class UtileriaExportar {
	public  Font HELVETICANORMAL= new Font(Font.FontFamily.HELVETICA, 11,Font.NORMAL,BaseColor.BLACK);
	public  Font HELVETICABBLACK= new Font(Font.FontFamily.HELVETICA, 11,Font.BOLD,BaseColor.BLACK);
	public  Font HELVETICABAZUL= new Font(Font.FontFamily.HELVETICA, 11,Font.BOLD,new BaseColor(0,59,120));
	public  Font HELVETICABVERDE= new Font(Font.FontFamily.HELVETICA, 11,Font.BOLD,new BaseColor(0,89,103));
	
	public void creteEmptyLine( int number,Document document) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
		document.add(paragraph);
	}
	
	public void titulosCentradosSinBorde(Document document, String titulo) throws BadElementException, DocumentException {
        PdfPTable tabla = new PdfPTable(1);
        tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        PdfPCell celda;
        tabla.setWidthPercentage(100);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda = new PdfPCell(new Paragraph(titulo, HELVETICABAZUL));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBorder(Rectangle.NO_BORDER);
        tabla.addCell(celda);
        document.add(tabla);
    }
	
	public void espacioRenglon(Document document) throws BadElementException, DocumentException {
        PdfPTable tabla = new PdfPTable(1);
        tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        PdfPCell celda;
        tabla.setWidthPercentage(100);
        tabla.getDefaultCell().setFixedHeight(1);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda = new PdfPCell(new Paragraph("", HELVETICANORMAL));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBorder(Rectangle.NO_BORDER);
        tabla.addCell(celda);
        document.add(tabla);
    }
}
