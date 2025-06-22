public class RealImage implements Image{
    private String filename;

    public RealImage(String filename){
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer(){
        System.out.println("Loading "+filename+" from remote server...");
    }

    public void display(){
        System.out.println("Displaying: "+filename);
    }
}
