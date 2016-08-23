package ru.gradis.sovzond.jdbc.sql;

/**
 * Created by donchenko-y on 6/8/16.
 */
public class SqlStorage {

	public final static Integer TEXT = 2147483647;
	public final static Integer BYTEA = 2147483647;

	public static final String GET_XML_FILES = "SELECT * FROM test.pr_create_xml_kpt(:i_text, :i_scheme_id)";
	public static final String GET_XML_FILES2 = "SELECT * FROM test.pr_create_xml_common(:i_text, :i_scheme_id)";

}
