package ru.gradis.sovzond.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.gradis.sovzond.jdbc.extractor.FilesExtractor;
import ru.gradis.sovzond.model.domain.FileVO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by donchenko-y on 7/27/16.
 */
public class FilesRowMapper implements RowMapper<FileVO> {
	@Override
	public FileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FilesExtractor filesExtractor = new FilesExtractor();
		return filesExtractor.extractData(rs);
	}
}
