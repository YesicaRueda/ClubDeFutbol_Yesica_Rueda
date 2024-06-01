package com.Parcial3_Java_R_D.app.util;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.Parcial3_Java_R_D.app.entidades.Asociacion;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("listarAsociacion")
public class ListaAsociaciones extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		List<Asociacion> findAll = (List<Asociacion>)model.get("asociacion");
		
		PdfPTable tablaAsociaciones = new PdfPTable(4);
		
		findAll.forEach(asociacion->{
			
			tablaAsociaciones.addCell(asociacion.getId().toString());
			tablaAsociaciones.addCell(asociacion.getNombre());
			tablaAsociaciones.addCell(asociacion.getPais());
			tablaAsociaciones.addCell(asociacion.getPresidente());

			
		});
		
		document.add(tablaAsociaciones);
	}

}
