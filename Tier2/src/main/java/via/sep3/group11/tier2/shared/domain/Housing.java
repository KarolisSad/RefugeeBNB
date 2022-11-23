package via.sep3.group11.tier2.shared.domain;

import lombok.Data;

@Data
public class Housing {
    private long housingId;
    private int capacity;
    private Address address;

    // todo validation
}
