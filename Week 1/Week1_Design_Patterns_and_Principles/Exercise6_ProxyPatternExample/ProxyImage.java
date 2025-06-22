public class ProxyImage implements Image{
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename){
        this.filename = filename;
    }

    public void display(){
        if(realImage == null){
            realImage = new RealImage(filename);
        }
        else{
            System.out.println("Using cached image: "+filename);
        }

        realImage.display();
    }
}
