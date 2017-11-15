package modbus;

import de.re.easymodbus.server.ModbusServer;

import java.io.IOException;

public class ServerService {

    public ModbusServer startServer(int port){
        ModbusServer server = new ModbusServer();
        server.setPort(port);
        server.start();
        try {
            server.Listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(server.getServerRunning()){
            System.out.println("Modbus server started on port " + port);
        } else {
            System.out.println("Modbus server starting error (ServerService.startServer())");
        }
        return server;
    }

    public void stopServer(ModbusServer server){
        server.StopListening();
        server.stop();
        if(server.getServerRunning()){
            System.out.println("Modbus server is still alive");
        } else {
            System.out.println("Modbus server stopped");
        }
    }

}
