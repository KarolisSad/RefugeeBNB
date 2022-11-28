package via.sep3.group11.tier3.GrpcImplementation.converters;

import via.sep3.group11.tier3.model.*;
import via.sep3.group11.tier3.protobuf.*;

public class GrpcConverter {

    public static Host HostFromGrpc(GHost grpcHost) {
        return new Host(
                grpcHost.getEmail(),
                grpcHost.getFirstName(),
                grpcHost.getMiddleName(),
                grpcHost.getLastName(),
                grpcHost.getPassword(),
                grpcHost.getNationality(),
                grpcHost.getGender().charAt(0),
                new Date(grpcHost.getDateOfBirth().getDay(),grpcHost.getDateOfBirth().getMonth(), grpcHost.getDateOfBirth().getYear()));

                //TODO ADD Housing
    }

    public static GHost HostToGrpc(Host host) {
            return GHost.newBuilder()
               .setFirstName(host.getFirstName())
               .setEmail(host.getEmail())
               .setPassword(host.getPassword())
               .setGender(String.valueOf(host.getGender()))
               .setNationality(host.getNationality())
               .setMiddleName(host.getMiddleName())
               .setLastName(host.getLastName()).setDateOfBirth(DateToGrpc(host.getDateOfBirth()))
                    .build();
                //TODO ADD Housing
    }


    public static Refugee RefugeeFromGrpc(GRefugee grpcRefugee) {
        return new Refugee(
                grpcRefugee.getEmail(),
                grpcRefugee.getFirstName(),
                grpcRefugee.getMiddleName(),
                grpcRefugee.getLastName(),
                grpcRefugee.getPassword(),
                grpcRefugee.getNationality(),
                grpcRefugee.getGender().charAt(0),
                DateFromGrpc(grpcRefugee.getDateOfBirth()));
    }

    public static GRefugee RefugeeToGrpc(Refugee refugee)
    {
        return GRefugee.newBuilder()
                .setEmail(refugee.getEmail())
                .setPassword(refugee.getPassword())
                .setGender(String.valueOf(refugee.getGender()))
                .setNationality(refugee.getNationality())
                .setFirstName(refugee.getFirstName())
                .setMiddleName(refugee.getMiddleName())
                .setLastName(refugee.getLastName())
                .setDateOfBirth(DateToGrpc(refugee.getDateOfBirth()))
                   .build();
    }

    public static GAddress AddressToGrpc(Address address)
    {
        return GAddress.newBuilder()
                .setCountry(address.getCountry())
                .setCity(address.getCity())
                .setStreetName(address.getStreetName())
                .setHouseNumber(address.getHouseNumber())
                .setRoomNumber(address.getRoomNumber())
                .setPostCode(address.getPostalCode())
                .setId(address.getAddressId()).build();
    }

    public static Address AddressFromGrpc(GAddress address)
    {
        return new Address(
                address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreetName(),
                address.getHouseNumber(),
                address.getRoomNumber(),
                address.getPostCode());
    }

    public static Housing HousingFromGrpc(GHousing returnedHousing) {
        return new Housing(
                returnedHousing.getCapacity(),
                AddressFromGrpc(returnedHousing.getAddress()));
    }

    public static GHousing HousingToGrpc(Housing housing)
    {
        return GHousing.newBuilder()
                .setCapacity(housing.getCapacity())
                .setAddress(AddressToGrpc(housing.getAddress())).build();
    }


    public static GDateOfBirth DateToGrpc(Date date)
    {
        return GDateOfBirth.newBuilder()
                .setDay(date.getDay())
                .setMonth(date.getMonth())
                .setYear(date.getYear())
                    .build();
    }

    public static Date DateFromGrpc(GDateOfBirth date) {
        return new Date(
                date.getDay(),
                date.getMonth(),
                date.getYear());
    }

}
