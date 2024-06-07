package tp06;

import java.time.LocalDate;

public class Car
{
    private double temporalDropRate;
    private double mileageDropRate;
    private String brand;
    private LocalDate onRoad;
    private double purchasePrice;
    private LocalDate onSale;
    private double salePrice;
    private int mileage;

    public Car(String brand, LocalDate onRoad, double pPrice, LocalDate onSale, double sPrice, int km)
    {
        this.brand=brand;
        this.onRoad=onRoad;
        this.purchasePrice=pPrice;
        this.onSale=onSale;
        this.salePrice=sPrice;
        this.mileage=km;
    }

    public Car(String brand, LocalDate onRoad, double pPrice, int km)
    {
        this.brand=brand;
        this.onRoad=onRoad;
        this.purchasePrice=pPrice;
        this.mileage=km;
        this.salePrice=pPrice;
        this.onSale=LocalDate.now();
    }

    public String getBrand()
    {
        return brand;
    }

    public int getMileage()
    {
        return mileage;
    }
   
    public LocalDate getOnRoad()
    {
        return onRoad;
    }

    public LocalDate getOnSale()
    {
        return onSale;
    }

    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice)
    {
        this.salePrice = salePrice;
    }

    public double computeDropRate()
    {
        return 0.0;//NON TERMINER        
    }

    public double getMileageDropRate() {
        return mileageDropRate;
    }

    public double getTemporalDropRate() {
        return temporalDropRate;
    }
}