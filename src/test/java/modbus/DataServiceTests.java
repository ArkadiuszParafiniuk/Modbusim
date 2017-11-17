package modbus;

import data.DataService;
import data.DataServiceImpl;
import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;
import de.re.easymodbus.server.ModbusServer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public class DataServiceTests {

    @Test
    public void setAllDataTest(){
        int valueToset = 33;
        SlaveService slave = new SlaveServiceImpl();
        ModbusServer server = slave.startServer(1522);
        DataService service = new DataServiceImpl();
        service.setAllPointsToValue(server, "localhost", valueToset);

        MasterService master = new MasterServiceImpl();
        ModbusClient client = master.openClient("localhost", 1522);
        int[] result = null;
        try {
            result = client.ReadHoldingRegisters(0,125);
        } catch (ModbusException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(valueToset, result[0]);
        assertEquals(valueToset, result[76]);
        assertEquals(valueToset, result[124]);
    }

}
