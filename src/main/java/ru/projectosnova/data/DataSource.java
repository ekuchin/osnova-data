package ru.projectosnova.data;

abstract class DataSource {

	private String name;
	private String type;
	private String protocol;
	private String host;
	private String port;
	private String uri;
	private String username;
	private String password;

	//CRUD operations
	abstract String create(String className, String host, String uri, String json, String params);
	abstract String read(String host, String uri, String unid,String params);
	abstract String update(String host, String uri, String unid, String json, String replaceAllItems, String params);
	abstract String delete(String host, String uri, String unid, String params);

	//Collection operations
	//public String search(String host, String uri, String collection, String params);
	//public String searchByKey(String host, String uri, String collection, String key, String sortBy, boolean sortAscending, boolean exactMatch, String params);
	//public String getNavigationData(String host, String uri, String collection, String page, String count, String sortBy, boolean sortAscending, String search, boolean exactMatch, String params);

	public String getType(){
		return type;
	}

}