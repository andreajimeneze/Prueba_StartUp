package cl.praxis.startup3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private int id;
    private String url;
    private String model;
    private int supplierId;
    private String supplierName;


    public CarDTO(int id, String url, String model, String supplierName) {
        this.id = id;
        this.url = url;
        this.model = model;
        this.supplierName = supplierName;
    }
}
