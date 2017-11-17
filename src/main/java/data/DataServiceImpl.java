package data;

import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;
import de.re.easymodbus.server.ModbusServer;
import modbus.MasterService;
import modbus.MasterServiceImpl;

import java.io.IOException;
import java.util.Arrays;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public class DataServiceImpl implements DataService {


    public void setAllPointsToValue(ModbusServer server, String address, int value) {
        MasterService master = new MasterServiceImpl();
        ModbusClient client = master.openClient(address, server.getPort());
        int[] array = new int[125];
        Arrays.fill(array, value);
        try {
            client.WriteMultipleRegisters(0, array);
            System.out.println("ok");
        } catch (ModbusException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
