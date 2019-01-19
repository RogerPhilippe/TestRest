package model;

import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class Parking {

    private Long idParking;

    private String nameParking;

    private String latitudeParking;

    private String longitudeParking;

    private String addressParking;

    private Integer numberParking;

    private String complementParking;

    private String bairroParking;

    private Long cityParking;

    private Integer stateParking;

    private double pricePerHourParking;

    private double pricePerDayParking;

    private double priceOvernightStayParking;

    private double priceMonthMotoParking;

}
