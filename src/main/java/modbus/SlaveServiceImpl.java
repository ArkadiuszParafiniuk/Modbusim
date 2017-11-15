package modbus;

import de.re.easymodbus.server.ModbusServer;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public class SlaveServiceImpl implements SlaveService {

    final static Logger logger = Logger.getLogger(SlaveServiceImpl.class);

    public ModbusServer startServer(int port){
        ModbusServer server = new ModbusServer();
        server.setPort(port);
        server.start();
        try {
            server.Listen();
        } catch (IOException e) {
            logger.error("Modbus server listening error");
            e.printStackTrace();
        }
        if(server.getServerRunning()){
            logger.info("Server running on port: " + port);
        } else {
            logger.error("Modbus server starting error");
        }
        return server;
    }

    public void stopServer(ModbusServer server){
        server.StopListening();
        server.stop();
        logger.info("Modbus server stopped");
    }

}
