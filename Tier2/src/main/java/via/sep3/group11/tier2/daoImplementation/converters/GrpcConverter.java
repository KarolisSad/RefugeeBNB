package via.sep3.group11.tier2.daoImplementation.converters;

import via.sep3.group11.tier2.protobuf.*;
import via.sep3.group11.tier2.shared.domain.*;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

public class GrpcConverter {

    public static Host HostFromGrpc(GHost grpcHost) throws ValidationException {
        return new Host(grpcHost.getFirstName(),grpcHost.getEmail(), grpcHost.getPassword(),
                grpcHost.getGender().charAt(0),grpcHost.getNationality(), grpcHost.getMiddleName(),
                grpcHost.getLastName(), new Date(grpcHost.getDateOfBirth().getDay(),grpcHost.getDateOfBirth().getMonth(),
                grpcHost.getDateOfBirth().getYear()));
                //TODO ADD Housing
    }

    public static GHost HostToGrpc(Host host) {
            return GHost.newBuilder().setFirstName(host.getFirstName()).setEmail(host.getEmail())
                .setPassword(host.getPassword()).setGender(String.valueOf(host.getGender()))
                .setNationality(host.getNationality()).setMiddleName(host.getMiddleName())
                .setLastName(host.getLastName()).setDateOfBirth(DateToGrpc(host.getDateOfBirth())).build();
                //TODO ADD Housing
    }


    public static Refugee RefugeeFromGrpc(GRefugee grpcRefugee) throws ValidationException {
        return new Refugee(grpcRefugee.getEmail(), grpcRefugee.getPassword(), grpcRefugee.getGender()
                .charAt(0),grpcRefugee.getNationality(),grpcRefugee.getFirstName()
                ,Optional.of(grpcRefugee.getMiddleName()),grpcRefugee.getLastName()
                ,DateFromGrpc(grpcRefugee.getDateOfBirth()));
    }

    public static GRefugee RefugeeToGrpc(Refugee refugee)
    {
        return GRefugee.newBuilder().setEmail(refugee.getEmail()).setPassword(refugee.getPassword())
                .setGender(String.valueOf(refugee.getGender())).setNationality(refugee.getNationality())
                .setFirstName(refugee.getFirstName()).setMiddleName(refugee.getMiddleName())
                .setLastName(refugee.getLastName()).setDateOfBirth(DateToGrpc(refugee.getDateOfBirth())).build();
    }

    public static GAddress AddressToGrpc(Address address)
    {
        return GAddress.newBuilder().setCountry(address.getCountry())
                .setCity(address.getCity()).setStreetName(address.getStreetName())
                .setHouseNumber(address.getHouseNumber()).setRoomNumber(address.getRoomNumber())
                .setPostCode(address.getPostCode()).setId(address.getAddressId()).build();
    }

    public static Address AddressFromGrpc(GAddress address)
    {
        return new Address(address.getId(), address.getCountry(), address.getCity(),
                address.getStreetName(), address.getHouseNumber(), address.getRoomNumber(),
                address.getPostCode());
    }

    public static Housing HousingFromGrpc(GHousing returnedHousing) {
        return new Housing(returnedHousing.getCapacity(),
                AddressFromGrpc(returnedHousing.getAddress()));
    }

    public static GHousing HousingToGrpc(Housing housing)
    {
        return  GHousing.newBuilder().setCapacity(housing.getCapacity())
                .setAddress(AddressToGrpc(housing.getAddress())).build();
    }


    public static GDateOfBirth DateToGrpc(Date date)
    {
        return GDateOfBirth.newBuilder().setDay(date.getDay())
                .setMonth(date.getMonth()).setYear(date.getYear()).build();
    }

    public static Date DateFromGrpc(GDateOfBirth date) throws ValidationException {
        return new Date(date.getDay(), date.getMonth(), date.getYear());
    }




    public static GAddHousingRequest AddHousingRequest(Housing housing, String email)
    {
        return GAddHousingRequest.newBuilder().setHousing(HousingToGrpc(housing)).setEmail(email).build();
    }
}
