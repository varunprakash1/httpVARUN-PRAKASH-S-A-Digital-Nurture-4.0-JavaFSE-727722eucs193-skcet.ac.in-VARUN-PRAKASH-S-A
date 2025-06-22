public class Main {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
                    .setCPU("Intel i5")
                    .setRAM("8GB")
                    .setStorage("512GB SSD")
                    .build();
        
        basicComputer.showConfig();
        System.out.println();

        Computer gamingComputer = new Computer.Builder()
                    .setCPU("Intel i9")
                    .setRAM("32GB")
                    .setStorage("1TB SSD")
                    .setGraphicsCard("NVIDIA RTX 4080")
                    .setBluetooth(true)
                    .build();
                
        gamingComputer.showConfig();
    }
}
