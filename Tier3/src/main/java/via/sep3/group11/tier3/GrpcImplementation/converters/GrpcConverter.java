package via.sep3.group11.tier3.GrpcImplementation.converters;

import via.sep3.group11.tier3.model.*;
import via.sep3.group11.tier3.protobuf.*;

import static via.sep3.group11.tier3.model.Date.convertDateObjectToLocalDate;
import static via.sep3.group11.tier3.model.Date.convertLocalDateToDateObject;

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
                new Date(grpcHost.getDateOfBirth().getDay(), grpcHost.getDateOfBirth().getMonth(), grpcHost.getDateOfBirth().getYear()));

        //TODO ADD Housing
    }

    public static GHost HostToGrpc(Host host) {

        System.out.println("DATA TIER CHECKING GENDER BEFORE CONVERT: " + host.getGender());
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

    public static GHostDetails HostDetailsToGrpc(Host host) {
        return GHostDetails.newBuilder()
                .setFirstName(host.getFirstName())
                .setEmail(host.getEmail())
                .setPassword(host.getPassword())
                .setGender(String.valueOf(host.getGender()))
                .setNationality(host.getNationality())
                .setMiddleName(host.getMiddleName())
                .setLastName(host.getLastName())
                .setDateOfBirth(DateToGrpc(host.getDateOfBirth()))
                .build();
    }

    public static Host HostDetailsfromGrpc(GHostDetails grpcHostDetails)
    {
        return new Host(
                grpcHostDetails.getEmail(),
                grpcHostDetails.getFirstName(),
                grpcHostDetails.getMiddleName(),
                grpcHostDetails.getLastName(),
                grpcHostDetails.getPassword(),
                grpcHostDetails.getNationality(),
                grpcHostDetails.getGender().charAt(0),
                DateFromGrpc(grpcHostDetails.getDateOfBirth()));
    }


    public static Refugee refugeeFromGrpc(GRefugee grpcRefugee) {
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

    public static GRefugee refugeeToGrpc(Refugee refugee) {
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

    public static GAddress AddressToGrpc(Address address) {
        return GAddress.newBuilder()
                .setCountry(address.getCountry())
                .setCity(address.getCity())
                .setStreetName(address.getStreetName())
                .setHouseNumber(address.getHouseNumber())
                .setRoomNumber(address.getRoomNumber())
                .setPostCode(address.getPostalCode())
                .setId(address.getAddressId()).build();
    }

    public static Address AddressFromGrpc(GAddress address) {
        return new Address(
                address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreetName(),
                address.getHouseNumber(),
                address.getRoomNumber(),
                address.getPostCode());
    }

    public static Housing housingFromGrpc(GHousing returnedHousing) {
        return new Housing(
                returnedHousing.getCapacity(),
                AddressFromGrpc(returnedHousing.getAddress()));
    }

    public static GHousing housingToGrpc(Housing housing) {
        return GHousing.newBuilder()
                .setCapacity(housing.getCapacity())
                .setAddress(AddressToGrpc(housing.getAddress())).build();
    }


    public static GDateOfBirth DateToGrpc(Date date) {
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

    public static Agreement AgreementWithIdFromGrpc(GAgreement agreement) {
        return new Agreement(
                agreement.getId(),
                DateFromGrpc(agreement.getDateOfCreation()),
                refugeeFromGrpc(agreement.getRefugee()),
                housingFromGrpc(agreement.getHousing()),
                HostDetailsfromGrpc(agreement.getHostDetails()),
                agreement.getStatus());
    }

    public static GAgreement AgreementWithIdToGrpc(Agreement agreement) {
        return GAgreement.newBuilder()
                .setId(agreement.getAgreementId())
                .setDateOfCreation(DateToGrpc(convertLocalDateToDateObject(agreement.getDate())))
                .setHostDetails(HostDetailsToGrpc(agreement.getHost()))
                .setHousing(housingToGrpc(agreement.getHousing()))
                .setRefugee(refugeeToGrpc(agreement.getRefugee()))
                .setStatus(agreement.isAccepted()).build();

    }

    public static GAgreement AgreementToGrpc(Agreement agreement)
    {
        return GAgreement.newBuilder()
                .setDateOfCreation(DateToGrpc(convertLocalDateToDateObject(agreement.getDate())))
                .setRefugee(refugeeToGrpc(agreement.getRefugee()))
                .setHostDetails(HostDetailsToGrpc(agreement.getHost()))
                .setHousing(housingToGrpc(agreement.getHousing()))
                .setStatus(agreement.isAccepted()).build();
    }

    public static Agreement AgreementFromGrpc(GAgreement agreement) {
        return new Agreement(
                DateFromGrpc(agreement.getDateOfCreation()),
                refugeeFromGrpc(agreement.getRefugee()),
                housingFromGrpc(agreement.getHousing()),
                HostDetailsfromGrpc(agreement.getHostDetails()));
    }


}


