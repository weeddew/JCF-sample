package system.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public  class CommonDAO  {


	@Autowired
	private QueryExecutor queryExecutor;


	private Map<String, QueryExecutor> datasource;


	public void setDatasource(Map<String, QueryExecutor> datasource) {
		this.datasource = datasource;
	}

	public QueryExecutor getQueryExecutor() {
		return queryExecutor;
	}


	public void setQueryExecutor(QueryExecutor queryExecutor) {
		this.queryExecutor = queryExecutor;
	}

	public int queryForInt(Object statementTemplate, Object parameter, String connectionInfo){
		QueryExecutor  queryExecutor=datasource.get(connectionInfo);
		return 	queryExecutor.queryForInt(statementTemplate, parameter);
	}


	public int queryForInt(Object statementTemplate, Object parameter){
		return  queryExecutor.queryForInt(statementTemplate, parameter);
	}
	public long queryForLong(Object statementTemplate, Object parameter){
		return  queryExecutor.queryForLong(statementTemplate, parameter);
	}




	public List<Map<String, Object>> queryForList(Object statementTemplate, Object parameter, boolean usePropertyName) {
		return queryExecutor.queryForMapList(statementTemplate, parameter,usePropertyName );
	}
	public List<Map<String, Object>> queryForList(Object statementTemplate, Object parameter) {
		return queryForList(statementTemplate, parameter,true );
	}
	public List<Map>   queryForList(Object statementTemplate, Object parameter, final int skipRows, final int maxRows){
		return  queryExecutor.queryForList(statementTemplate, parameter,skipRows,  maxRows, Map.class);
	}


	public <T>List<T> queryForList(Object statementTemplate, Object parameter, Class clazz){
		List queryForList = queryExecutor.queryForList(parameter, parameter, clazz);
		return  queryForList;
	}

	public <T>List<T> queryForList(Object statementTemplate, Object parameter, final int skipRows, final int maxRows, Class<T> clazz){
		return queryExecutor.queryForList(statementTemplate, parameter, skipRows, maxRows, clazz);

	}


	public Object queryForObject(Object statementTemplate, Object parameter,Class clazz ){
		return queryExecutor.queryForObject(statementTemplate, parameter, clazz);
	}


	public Map queryForObject(Object statementTemplate, Object parameter){
		return queryExecutor.queryForMap(statementTemplate, parameter);
	}


	public int update(Object statementTemplate, Object parameter){

		return queryExecutor.update(statementTemplate, parameter);
	}

	public <T> T executeProcedure(Object statementTemplate, Object parameter, Class<T> clazz) {
		return	queryExecutor.executeProcedure(statementTemplate, parameter, clazz);
	}

	public Map<String, Object>  executeProcedure(Object statementTemplate, Object parameter) {
		return	queryExecutor.executeProcedure(statementTemplate, parameter);
	}

	public <T> T executeFunction(Object statementTemplate, Object parameter, Class<T> clazz) {
		return  queryExecutor.executeFunction(statementTemplate,parameter,clazz );
	}
	public  Map<String, Object> executeFunction(Object statementTemplate, Object parameter) {
		return  queryExecutor.executeFunction(statementTemplate,parameter );
	}
}
