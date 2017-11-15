package modbus;

import de.re.easymodbus.modbusclient.ModbusClient;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public interface MasterService {

    ModbusClient openClient(String adress, int port);

    void closeClient(ModbusClient client);
}
