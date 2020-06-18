package ru.projectosnova.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.projectosnova.config.ConfigNotFoundException;
import ru.projectosnova.config.InvalidConfigObjectException;
import ru.projectosnova.config.InvalidConfigStructureException;

import java.io.IOException;

public class DominoDataSourceTest extends Assert {
    private DataSource domino;

    @Before
    public void init() throws ConfigNotFoundException, UnsupportedDataSourceException, InvalidConfigObjectException, InvalidConfigStructureException, InvalidDataSourceException, IOException {
        domino = DataSourceFactory.build("datasources","mk2auto");
     }

    @Test
    public void testCRUD(){
        String unid = "";
        //String unid = domino.create("")

        String s = domino.read("");

        assertEquals(s,"YWdhcG92OjEyM3F3ZQ==");
    }

}
