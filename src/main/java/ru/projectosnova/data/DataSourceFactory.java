package ru.projectosnova.data;

import ru.projectosnova.config.*;

import java.io.IOException;

public class DataSourceFactory {

    public static DataSource build(String config, String name) throws InvalidConfigStructureException, InvalidConfigObjectException, IOException, ConfigNotFoundException {
        Config datasources = new Config(config);
        DataSource ds = (DataSource)datasources.getByProperty(DataSource.class, "name", name);

        switch(ds.getType()) {

            case "domino":
                DataSource dominoSource=(DataSource) new DominoDataSource();
                return dominoSource;

            default:

                break;
        }
        return null;
    }

}
