package ru.gradis.sovzond.model.dao.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.gradis.sovzond.jdbc.mapper.FilesRowMapper;
import ru.gradis.sovzond.jdbc.sql.SqlStorage;
import ru.gradis.sovzond.model.dao.XmlExportDAO;
import ru.gradis.sovzond.model.domain.FileVO;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by donchenko-y on 7/27/16.
 */
public class XmlExportDAOImpl implements XmlExportDAO {

	private static final Log log = LogFactoryUtil.getLog(XmlExportDAOImpl.class);


	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	public XmlExportDAOImpl(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<FileVO> executeExport(String regularEx) {

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("i_text", regularEx);
		MapSqlParameterSource in = new MapSqlParameterSource().addValues(inParamMap);

		List<FileVO> files = namedParameterJdbcTemplate.query(SqlStorage.GET_XML_FILES, in, new FilesRowMapper());

		return files;
	}


}
