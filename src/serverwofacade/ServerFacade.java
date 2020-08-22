package serverwofacade;

public class ServerFacade {
    private static ServerFacade serverFacade = null;
    private static ScheduleServer scheduleServer = new ScheduleServer();
    public static ServerFacade getServerFacade(){
        if(serverFacade == null){
            serverFacade = new ServerFacade();
        }
        return serverFacade;
    }

    public void startScheduleServer(){
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();   
    }

    public void stopScheduleServer(){
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }

}