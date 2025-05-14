//Leen Alamm, Leen Abhari, Simrah Shabandri
package org.example.l2s.seeder;

import jakarta.annotation.PostConstruct;
import org.example.l2s.model.Car;
import org.example.l2s.model.Supplier;
import org.example.l2s.repository.CarRepository;
import org.example.l2s.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    public void seedData() {
        try {
            seedSuppliers();
            seedCars();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void seedSuppliers() {
        if (supplierRepository.count() == 0) {
            this.supplierRepository.save(new Supplier("AutoHub Rentals", "123 Main St, Dubai", "050-123-4567", 4.7));
            this.supplierRepository.save(new Supplier("SpeedyCars UAE", "45 Sheikh Zayed Rd, Dubai", "050-234-5678", 4.5));
            this.supplierRepository.save(new Supplier("Desert Drive Deals", "99 Al Barsha, Dubai", "050-345-6789", 4.3));
            this.supplierRepository.save(new Supplier("Luxury Wheels", "18 Marina Walk, Dubai", "050-456-7890", 4.9));
        }
    }

    public void seedCars(){
        if (carRepository.count() == 0 && supplierRepository.count() == 4) {
            Supplier supplier1 = supplierRepository.findById(1).orElse(null);
            Supplier supplier2 = supplierRepository.findById(2).orElse(null);
            Supplier supplier3 = supplierRepository.findById(3).orElse(null);
            Supplier supplier4 = supplierRepository.findById(4).orElse(null);


            // Save 15 LUXURIOUUUUUUUUUUUUUUUUUUS cars
            this.carRepository.save(new Car("BMW", "3 Series", 350, "Excellent", true, supplier3,"/images/bmw3series.png"));
            this.carRepository.save(new Car("BMW", "M4", 700, "Excellent", true, supplier2,"/images/bmwm4.png"));
            this.carRepository.save(new Car("Ford", "Mustang", 300, "Excellent", true, supplier4,"/images/fordmustang.png"));
            this.carRepository.save(new Car("Audi", "A6", 380, "Excellent", true, supplier1,"/images/audia6.png"));
            this.carRepository.save(new Car("Mercedes-Benz", "C-Class", 420, "Good", true, supplier2,"/images/mercbenz.png"));
            this.carRepository.save(new Car("Porsche", "911", 600, "Excellent", true, supplier3,"/images/porsche.png"));
            this.carRepository.save(new Car("Jaguar", "F-Type", 450, "Good", true, supplier4,"/images/jaguar.png"));
            this.carRepository.save(new Car("Lexus", "RX 350", 350, "Good", true, supplier1,"/images/lexus.png"));
            this.carRepository.save(new Car("Tesla", "Model S", 500, "Excellent", true, supplier2,"/images/tesla.png"));
            this.carRepository.save(new Car("Range Rover", "Velar", 550, "Excellent", true, supplier3,"/images/rangerover.png"));
            this.carRepository.save(new Car("Maserati", "Levante", 650, "Good", true, supplier1,"/images/maserati.png"));
            this.carRepository.save(new Car("Bentley", "Continental GT", 800, "Good", true, supplier4,"/images/bentley.png"));
            this.carRepository.save(new Car("Rolls-Royce", "Ghost", 1000, "Excellent", true, supplier2,"/images/rollsroyce.png"));
            this.carRepository.save(new Car("Bugatti", "La Voiture Noire", 1200, "Excellent", true, supplier3,"/images/bugatti.png"));
            this.carRepository.save(new Car("Aston Martin", "DB11", 900, "Good", true, supplier4,"/images/astonmartin.png"));

        }

    }

}
