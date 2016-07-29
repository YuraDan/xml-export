package ru.gradis.sovzond.model.dao;

import ru.gradis.sovzond.model.domain.FileVO;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by donchenko-y on 7/27/16.
 */
public interface XmlExportDAO {

	public List<FileVO> executeExport(String regularEx);

}
