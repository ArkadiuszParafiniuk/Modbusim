package modbus;

import de.re.easymodbus.modbusclient.ModbusClient;
import de.re.easymodbus.server.ModbusServer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public class ModbusClientServerConnectionTests {
    MasterService master = new MasterServiceImpl();
    SlaveService slave = new SlaveServiceImpl();
    ModbusServer server;
    ModbusClient client;

    @Test
    public void createStartAndStopServerTest(){
        server = slave.startServer(1522);
        assertTrue(server.getServerRunning());
        slave.stopServer(server);
        assertFalse(server.getServerRunning());
    }

    @Test
    public void createClientAndConnectToServerTest(){
        server = slave.startServer(1522);
        client = master.openClient("localhost", 1522);
        assertTrue(client.isConnected());
        master.closeClient(client);
        assertFalse(client.isConnected());
        slave.stopServer(server);
        assertFalse(client.isConnected());
    }

}
