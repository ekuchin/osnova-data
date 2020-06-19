package ru.projectosnova.data;

import javax.json.bind.annotation.JsonbProperty;

abstract public class DataSource {

	private String name;
	private String type;
	private String protocol;
	private String host;
	private String port;
	private String uri;
	private String user;
	private String password;

	//CRUD operations
	abstract String create(String objectTypeName,String json)throws Exception;
	abstract String create(String objectTypeName, String json, String params)throws Exception;

	abstract String read(String unid,String params)throws Exception;
	abstract String read(String unid)throws Exception;

	abstract boolean update(String unid, String json)throws Exception;
	abstract boolean update(String unid, String json, boolean replaceAllItems)throws Exception;
	abstract boolean update(String unid, String json, String params)throws Exception;
	abstract boolean update(String unid, String json, boolean replaceAllItems, String params)throws Exception;

	abstract boolean delete(String unid, String params)throws Exception;
	abstract boolean delete(String unid)throws Exception;

	//Collection operations
	//public String search(String collection, String params);
	//public String searchByKey(String collection, String key, String sortBy, boolean sortAscending, boolean exactMatch, String params);
	//public String getNavigationData(String collection, String page, String count, String sortBy, boolean sortAscending, String search, boolean exactMatch, String params);

	public String getName(){
		return name;
	}
	public String getType(){
		return type;
	}
	public String getProtocol(){
		return protocol;
	}
	public String getHost(){
		return host;
	}
	public String getPort(){
		return port;
	}
	public String getUri(){
		return uri;
	}
	public String getUserName(){
		return user;
	}
	public String getPassword(){
		return password;
	}

	@JsonbProperty("name")
	public void setName(String name){
		this.name=name;
	}

	@JsonbProperty("type")
	public void setType(String type){
		this.type=type;
	}

	@JsonbProperty("protocol")
	public void setProtocol(String protocol){
		this.protocol=protocol;
	}

	@JsonbProperty("host")
	public void setHost(String host){
		this.host=host;
	}

	@JsonbProperty("port")
	public void setPort(String port){
		this.port=port;
	}

	@JsonbProperty("uri")
	public void setUri(String uri){
		this.uri=uri;
	}

	@JsonbProperty("user")
	public void setUser(String user){
		this.user=user;
	}

	@JsonbProperty("password")
	public void setPassword(String password){
		this.password=password;
	}
}