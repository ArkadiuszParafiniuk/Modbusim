package modbus;

import de.re.easymodbus.modbusclient.ModbusClient;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public class MasterServiceImpl implements MasterService {

    final static Logger logger = Logger.getLogger(MasterServiceImpl.class);

    public ModbusClient openClient(String address, int port) {
        ModbusClient client = new ModbusClient(address, port);
        try {
            client.Connect();
            logger.info("Client connected to modbus server");
        } catch (IOException e) {
            logger.error("Client-server connection error");
            e.printStackTrace();
        }
        return client;
    }

    public void closeClient(ModbusClient client) {
        try {
            client.Disconnect();
            logger.info("Client disconnected");
        } catch (IOException e) {
            logger.error("Client-server disconnection error");
            e.printStackTrace();
        }
    }
}
