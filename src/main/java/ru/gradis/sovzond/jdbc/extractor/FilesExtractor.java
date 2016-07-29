package ru.gradis.sovzond.jdbc.extractor;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.gradis.sovzond.model.domain.FileVO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by donchenko-y on 7/27/16.
 */
public class FilesExtractor implements ResultSetExtractor<FileVO> {


	@Override
	public FileVO extractData(ResultSet rs) throws SQLException, DataAccessException {
		FileVO file = new FileVO();

		file.setFileData(rs.getString("xmlfile"));
		file.setName(rs.getString("filename"));
		return file;
	}
}
