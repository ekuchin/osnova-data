package ru.projectosnova.data;

import org.junit.Assert;
import org.junit.Test;

public class DataSourceTest extends Assert {

    @Test
    public void datasourceNotFoundInConfigThrowsCorrectException(){
        boolean flag=false;
        try {
            DataSource ds = DataSourceFactory.build("nosuchname");
        }
        catch(InvalidDataSourceException e){
            System.out.println(e.getMessage());
            flag=true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertTrue(flag);
    }

    @Test
    public void incorrectDatasourceTypeThrowsException(){
        boolean flag=false;
        try {
            DataSource ds = DataSourceFactory.build( "oracletest");
        }
        catch(UnsupportedDataSourceException e){
            System.out.println(e.getMessage());
            flag=true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertTrue(true);
    }

}
