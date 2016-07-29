package ru.gradis.sovzond.portlet.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;;

import com.liferay.portal.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.gradis.sovzond.model.dao.XmlExportDAO;
import ru.gradis.sovzond.model.domain.FileVO;
import ru.gradis.sovzond.util.ErrorToResponse;

import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by donchenko-y on 6/30/16.
 */

@RestController
public class ExportController {

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private XmlExportDAO xmlExportDAO;
	private static final int BYTES_DOWNLOAD = 1024;

	private static final Log log = LogFactoryUtil.getLog(ExportController.class);

	@RequestMapping(value = "/XmlServices/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void xmlExport(@RequestParam(value = "regularEx", required = false) String regularEx, HttpServletResponse response) {

		List<FileVO> xmlFiles = null;
		xmlFiles = xmlExportDAO.executeExport(regularEx);

		InputStream is = null;
		ZipOutputStream out = null;

		if (!xmlFiles.isEmpty()) {
			response.setHeader("Content-Disposition", "attachment; filename=\"xmlFiles.zip\"");
			try {
				out = new ZipOutputStream(response.getOutputStream());

				byte[] buf = new byte[BYTES_DOWNLOAD];

				for (FileVO xmlFile : xmlFiles) {
					is = new ByteArrayInputStream(xmlFile.getFileData().getBytes(StandardCharsets.UTF_8));
					out.putNextEntry(new ZipEntry(xmlFile.getName()));
					int len;
					while ((len = is.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
					out.closeEntry();
					is.close();
				}
				out.close();
			} catch (IOException e) {
				log.error(e);
			}
		} else {
			try {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Нет файлов для упаковки в ZIP!");
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

}
