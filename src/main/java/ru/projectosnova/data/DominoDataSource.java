package ru.projectosnova.data;

import java.util.Base64;

public class DominoDataSource extends DataSource {

    //Create
    public String create(String json, String params){
        System.out.println("Domino Create");
        return("");
    };

    public String create(String json){
        return(this.create(json,""));
    };

    //Read
    public String read(String unid,String params){
        String token=getBasicAuthToken();
        return token;
    };

    public String read(String unid){
        return this.read(unid,"");
    };

    //Update
    public boolean update(String unid, String json, boolean replaceAllItems, String params){
        System.out.println("Domino Update");
        return true;
    }

    public boolean update(String unid, String json){
        return this.update(unid,json, false,"");
    }
    public boolean update(String unid, String json, boolean replaceAllItems){
        return this.update(unid,json, replaceAllItems,"");
    }
    public boolean update(String unid, String json, String params){
        return this.update(unid,json, false,"");
    }

    //Delete
    public boolean delete(String unid, String params){
        System.out.println("Domino Delete");
        return(true);
    }

    public boolean delete(String unid){
        return this.delete(unid,"");
    }

    public String getBasicAuthToken(){
        //YWdhcG92OjEyM3F3ZQ==
        String token = getUserName()+":"+getPassword();
        token = Base64.getEncoder().encodeToString(token.getBytes());
        return (token);
    }
}
