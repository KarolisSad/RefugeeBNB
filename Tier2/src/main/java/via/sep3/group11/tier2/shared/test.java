package via.sep3.group11.tier2.shared;

import via.sep3.group11.tier2.shared.domain.Date;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

public class test {
    public static void main(String[] args) throws ValidationException {
        Host host = new Host("null", "hello@hello.dk", "123456", 'M', "Danish", Optional.of("Hello"), "Pedersen", new Date(), null);
    }
}
