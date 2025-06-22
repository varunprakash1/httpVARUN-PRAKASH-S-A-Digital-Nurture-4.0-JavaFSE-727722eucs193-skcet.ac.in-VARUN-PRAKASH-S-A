public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("cat_photo.jpg");

        image.display();
        System.out.println();
        image.display();
    }
    
}
