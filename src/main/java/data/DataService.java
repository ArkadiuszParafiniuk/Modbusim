package data;

import de.re.easymodbus.server.ModbusServer;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public interface DataService {

    void setAllPointsToValue(ModbusServer server, String address, int value);

}
