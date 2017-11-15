package modbus;

import de.re.easymodbus.server.ModbusServer;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public interface SlaveService {

    ModbusServer startServer(int port);

    void stopServer(ModbusServer server);
}
