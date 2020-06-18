package ru.projectosnova.data;

import ru.projectosnova.config.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.StringReader;

public class DataSourceFactory {

    public static DataSource build(String config, String name) throws InvalidDataSourceException, InvalidConfigStructureException, InvalidConfigObjectException, IOException, ConfigNotFoundException, UnsupportedDataSourceException {
        Config datasources = new Config(config);
        String jsonString = datasources.getStringByProperty("name", name);

        if (jsonString==null){
            throw new InvalidDataSourceException("DataSource "+name+" not found in config");
        }

        JsonReader reader = Json.createReader((new StringReader(jsonString)));
        JsonObject jsonObject = reader.readObject();

        switch(jsonObject.getString("type")) {
            case "domino":
                Jsonb jsonb = JsonbBuilder.create();
                DominoDataSource dds=jsonb.fromJson(jsonString, DominoDataSource.class);
                return (DataSource) dds;
            default:
               throw new UnsupportedDataSourceException("Unsupported datasource - "+jsonObject.getString("type"));
         }
    }

}
