package via.sep3.group11.tier3.GrpcImplementation.converters;

import via.sep3.group11.tier3.model.*;
import via.sep3.group11.tier3.protobuf.*;

import static via.sep3.group11.tier3.model.Date.convertLocalDateToDateObject;

public class GrpcConverter {

    public static Host hostFromGrpc(GHost grpcHost) {
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

    public static GHost hostToGrpc(Host host) {
        return GHost.newBuilder()
                .setFirstName(host.getFirstName())
                .setEmail(host.getEmail())
                .setPassword(host.getPassword())
                .setGender(String.valueOf(host.getGender()))
                .setNationality(host.getNationality())
                .setMiddleName(host.getMiddleName())
                .setLastName(host.getLastName()).setDateOfBirth(dateToGrpc(host.getDateOfBirth()))
                .build();
        //TODO ADD Housing
    }

    public static GHostDetails hostDetailsToGrpc(Host host) {
        return GHostDetails.newBuilder()
                .setFirstName(host.getFirstName())
                .setEmail(host.getEmail())
                .setPassword(host.getPassword())
                .setGender(String.valueOf(host.getGender()))
                .setNationality(host.getNationality())
                .setMiddleName(host.getMiddleName())
                .setLastName(host.getLastName())
                .setDateOfBirth(dateToGrpc(host.getDateOfBirth()))
                .build();
    }

    public static Host hostDetailsFromGrpc(GHostDetails grpcHostDetails) {
        return new Host(
                grpcHostDetails.getEmail(),
                grpcHostDetails.getFirstName(),
                grpcHostDetails.getMiddleName(),
                grpcHostDetails.getLastName(),
                grpcHostDetails.getPassword(),
                grpcHostDetails.getNationality(),
                grpcHostDetails.getGender().charAt(0),
                dateFromGrpc(grpcHostDetails.getDateOfBirth()));
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
                dateFromGrpc(grpcRefugee.getDateOfBirth()),
                grpcRefugee.getFamilySize(),
                grpcRefugee.getAbout());
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
                .setDateOfBirth(dateToGrpc(refugee.getDateOfBirth()))
                .setFamilySize(refugee.getFamilySize())
                .setAbout(refugee.getDescription()).build();
    }

    public static GAddress addressToGrpc(Address address) {
        return GAddress.newBuilder()
                .setCountry(address.getCountry())
                .setCity(address.getCity())
                .setStreetName(address.getStreetName())
                .setHouseNumber(address.getHouseNumber())
                .setRoomNumber(address.getRoomNumber())
                .setPostCode(address.getPostalCode())
                .setId(address.getAddressId()).build();
    }

    public static Address addressFromGrpc(GAddress address) {
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
                returnedHousing.getId(),
                returnedHousing.getCapacity(),
                addressFromGrpc(returnedHousing.getAddress()));
    }

    public static Housing housingFromGrpcWithStatus(GHousingWithStatus returnedHousing) {
        return new Housing(
                returnedHousing.getId(),
                returnedHousing.getCapacity(),
                returnedHousing.getAvailable(),
                addressFromGrpc(returnedHousing.getAddress()));
    }

    public static GHousingWithStatus housingToGrpc(Housing housing) {
        return GHousingWithStatus.newBuilder()
                .setId(housing.getHousingId())
                .setCapacity(housing.getCapacity())
                .setAddress(addressToGrpc(housing.getAddress()))
                .setAvailable(housing.isAvailable())
                .build();
    }

    public static GDateOfBirth dateToGrpc(Date date) {
        return GDateOfBirth.newBuilder()
                .setDay(date.getDay())
                .setMonth(date.getMonth())
                .setYear(date.getYear())
                .build();
    }

    public static Date dateFromGrpc(GDateOfBirth date) {
        return new Date(
                date.getDay(),
                date.getMonth(),
                date.getYear());
    }

    public static Agreement agreementWithIdFromGrpc(GAgreement agreement) {
        return new Agreement(
                agreement.getId(),
                dateFromGrpc(agreement.getDateOfCreation()),
                refugeeFromGrpc(agreement.getRefugee()),
                housingFromGrpcWithStatus(agreement.getHousing()),
                hostDetailsFromGrpc(agreement.getHostDetails()),
                agreement.getStatus());
    }

    public static GAgreement agreementWithIdToGrpc(Agreement agreement) {
        return GAgreement.newBuilder()
                .setId(agreement.getAgreementId())
                .setDateOfCreation(dateToGrpc(convertLocalDateToDateObject(agreement.getDate())))
                .setHostDetails(hostDetailsToGrpc(agreement.getHost()))
                .setHousing(housingToGrpc(agreement.getHousing()))
                .setRefugee(refugeeToGrpc(agreement.getRefugee()))
                .setStatus(agreement.isAccepted()).build();
    }

    public static GAgreement agreementToGrpc(Agreement agreement) {
        return GAgreement.newBuilder()
                .setDateOfCreation(dateToGrpc(convertLocalDateToDateObject(agreement.getDate())))
                .setRefugee(refugeeToGrpc(agreement.getRefugee()))
                .setHostDetails(hostDetailsToGrpc(agreement.getHost()))
                .setHousing(housingToGrpc(agreement.getHousing()))
                .setStatus(agreement.isAccepted()).build();
    }

    public static Agreement agreementFromGrpc(GAgreement agreement) {
        return new Agreement(
                dateFromGrpc(agreement.getDateOfCreation()),
                refugeeFromGrpc(agreement.getRefugee()),
                housingFromGrpcWithStatus(agreement.getHousing()),
                hostDetailsFromGrpc(agreement.getHostDetails()));
    }
}


