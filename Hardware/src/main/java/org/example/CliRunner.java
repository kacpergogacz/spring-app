package org.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public abstract class CliRunner implements CommandLineRunner {
//    private final CompanyService companyService;
//    private final HardwareService hardwareService;
//    @Autowired
//    private ConfigurableApplicationContext context;
//
//    public CliRunner(CompanyService companyService, HardwareService hardwareService) {
//        this.companyService = companyService;
//        this.hardwareService = hardwareService;
//    }
//
//
//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//
//        while(true){
//            showMenu();
//            int command = scanner.nextInt();
//            switch (command){
//                case 1:
//                    showCommands();
//                    break;
//                case 2:
//                    listCompanies();
//                    break;
//                case 3:
//                    listHardwares();
//                    break;
//                case 4:
//                    addNewHardware();
//                    break;
//                case 5:
//                    deleteExistingHardware();
//                    break;
//                case 6:
//                    System.exit(SpringApplication.exit(context));
//                default:
//                    System.out.println("Invalid command.");
//
//            }
//        }
//
//    }
//
//    @Transactional
//    private void deleteExistingHardware() {
//        Scanner scanner = new Scanner(System.in);
//
//        Company company = null;
//        while(company ==null) {
//
//            System.out.println("Coompany name of the hardware you want to delete:");
//            String companyName = scanner.next();
//            company = companyService.getCompanyByName(companyName);
//            if (company ==null){
//                System.out.println("Invalid Company. Try again.");
//            }
//        }
//
//        List<Hardware> hardwareList = company.getHardwares();
//        if (hardwareList.isEmpty()) {
//            System.out.println("No hardware in this category.");
//            return;
//        }
//
//        System.out.println(company.getName() + ":");
//        for (int i = 0; i < hardwareList.size(); i++) {
//            Hardware hardware = hardwareList.get(i);
//            System.out.println((i + 1) + ". " + hardware.getName() + " (ID: " + hardware.getHardwareId() + ")");
//        }
//
//        System.out.println("Index of the hardware:");
//        int hardwareIndex = scanner.nextInt();
//        Hardware selectedHardware = hardwareList.get(hardwareIndex - 1);
//        hardwareService.deleteHardware(selectedHardware);
//        System.out.println("Hardware deleted.");
//
//
//
//    }
//
//    private void listHardwares() {
//        List<Hardware> hardwareList = hardwareService.getAllHardwares();
//        if (hardwareList.isEmpty()) {
//            System.out.println("There are no hardwares.");
//        }
//        else {
//            int index =1;
//            for (Hardware hardware : hardwareList) {
//                System.out.println(index+ "." + hardware);
//                index++;
//            }
//        }
//
//    }
//
//    @Transactional
//    private void addNewHardware() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Hardware name: ");
//        String name = scanner.next();
//
//        System.out.println("Hardware cost: ");
//        int cost = scanner.nextInt();
//        Company company =null;
//        while(company ==null) {
//            System.out.println("Company name for the hardware: ");
//            String companyName = scanner.next();
//            company = companyService.getCompanyByName(companyName);
//            if (company == null) {
//                System.out.println("Company not found. Try again.");
//            }
//        }
//
//        Hardware hardware = Hardware.builder()
//                .hardwareId(UUID.randomUUID())
//                .name(name)
//                .cost(cost)
//                .company(company)
//                .build();
//
//        hardwareService.addHardware(hardware);
//        System.out.println("Added new hardware.");
//    }
//
//    private void listCompanies() {
//        List<Company> companyList = companyService.getAllCompanies();
//        if (companyList.isEmpty()){
//            System.out.println("There are no companies.");
//        }
//        int index =1;
//        for (Company company : companyList) {
//            System.out.println(index+ "." + company);
//            index++;
//        }
//    }
//
//    private void showCommands() {
//        System.out.println("All Available Commands");
//        System.out.println("1 - List available commands");
//        System.out.println("2 - List all companies");
//        System.out.println("3 - List all hardwares");
//        System.out.println("4 - Add new Hardware");
//        System.out.println("5 - Delete existing hardware");
//        System.out.println("6 - Stop the application");
//    }
//
//    public void showMenu(){
//        System.out.println("Menu:");
//        System.out.println("1.List available commands");
//        System.out.println("2.List all companies");
//        System.out.println("3.List all hardwares");
//        System.out.println("4.Add new Hardware");
//        System.out.println("5.Delete existing hardware");
//        System.out.println("6.Stop the application");
//        System.out.print("Enter a command: ");
//    }
}
