public class Computer{
    private String CPU;
    private String RAM;
    private String Storage;
    private String graphicsCard;
    private boolean hasBluetooth;

    public Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.graphicsCard = builder.graphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    public static class Builder{
        private String CPU;
        private String RAM;
        private String Storage;
        private String graphicsCard;
        private boolean hasBluetooth;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }        
    }
    
    public void showConfig(){
        System.out.println("Computer Configuration:");
        System.out.println("CPU: "+CPU);
        System.out.println("RAM: "+RAM);
        System.out.println("Storage: "+Storage);
        System.out.println("Graphics Card: "+graphicsCard);
        System.out.println("Bluetooth: "+(hasBluetooth ? "Yes" : "No"));
    }
}