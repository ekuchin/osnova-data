package ru.projectosnova.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.projectosnova.config.ConfigNotFoundException;
import ru.projectosnova.config.InvalidConfigObjectException;
import ru.projectosnova.config.InvalidConfigStructureException;

import javax.json.Json;
import java.io.IOException;

public class DominoDataSourceTest extends Assert {
    private DataSource domino;

    @Before
    public void init() throws ConfigNotFoundException, UnsupportedDataSourceException, InvalidConfigObjectException, InvalidConfigStructureException, InvalidDataSourceException, IOException {
        domino = DataSourceFactory.build("datasources","mk2auto");
     }

    @Test
    public void testCRUD() throws Exception {
        System.out.println("Test CRUD");
        String jsonCreate = Json.createObjectBuilder()
                .add("firstName", "Ivan")
                .add("lastName", "Ivanoff")
                .add("age", "40")
                .build().toString();

        //String unid ="CC2ED5ECBF1FD5B5452582D800525863";
        //String unid = "F54576A3FEF3F4194525858C00272552";
        String unid = domino.create("Person",jsonCreate);
        System.out.println(unid);
        System.out.println(domino.read(unid));

        String jsonUpdate = Json.createObjectBuilder()
                .add("middleName", "Ivanovich")
                .add("age","30")
                .build().toString();

        if(domino.update(unid, jsonUpdate)){
            System.out.println(domino.read(unid));
        }

        if(domino.delete(unid)){
            assertTrue(true);
        }

    }

}
