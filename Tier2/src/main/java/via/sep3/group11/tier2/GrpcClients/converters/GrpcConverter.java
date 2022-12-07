package via.sep3.group11.tier2.GrpcClients.converters;
import via.sep3.group11.tier2.protobuf.*;
import via.sep3.group11.tier2.shared.domain.*;

import java.time.LocalDate;

public class GrpcConverter {

    public static Host hostFromGrpc(GHost grpcHost)  {
        return new Host(grpcHost.getFirstName(),
                grpcHost.getEmail(),
                grpcHost.getPassword(),
                grpcHost.getGender().charAt(0),
                grpcHost.getNationality(),
                grpcHost.getMiddleName(),
                grpcHost.getLastName(),
                new Date(grpcHost.getDateOfBirth().getDay(),grpcHost.getDateOfBirth().getMonth(),
                grpcHost.getDateOfBirth().getYear()));
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
                    .setLastName(host.getLastName())
                    .setDateOfBirth(dateToGrpc(host.getDateOfBirth())).build();
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

    public static Host hostDetailsFromGrpc(GHostDetails grpcHostDetails)
    {
        return new Host(
                grpcHostDetails.getFirstName(),
                grpcHostDetails.getEmail(),
                grpcHostDetails.getPassword(),
                grpcHostDetails.getGender().charAt(0),
                grpcHostDetails.getNationality(),
                grpcHostDetails.getMiddleName(),
                grpcHostDetails.getLastName(),
                dateFromGrpc(grpcHostDetails.getDateOfBirth()));
    }

    public static Refugee refugeeFromGrpc(GRefugee grpcRefugee) {
        return new Refugee(
                grpcRefugee.getEmail(),
                grpcRefugee.getPassword(),
                grpcRefugee.getGender().charAt(0),
                grpcRefugee.getNationality(),
                grpcRefugee.getFirstName(),
                grpcRefugee.getMiddleName(),
                grpcRefugee.getLastName(),
                dateFromGrpc(grpcRefugee.getDateOfBirth()),
                grpcRefugee.getFamilySize(),
                grpcRefugee.getAbout());
    }

    public static GRefugee refugeeToGrpc(Refugee refugee)
    {
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

    public static GAddress addressToGrpc(Address address)
    {
        return GAddress.newBuilder().setCountry(address.getCountry())
                .setCity(address.getCity())
                .setStreetName(address.getStreetName())
                .setHouseNumber(address.getHouseNumber()).setRoomNumber(address.getRoomNumber())
                .setPostCode(address.getPostCode()).setId(address.getAddressId()).build();
    }

    public static Address addressFromGrpc(GAddress address)  {
        return new Address(address.getId(), address.getCountry(), address.getCity(),
                address.getStreetName(), address.getHouseNumber(), address.getRoomNumber(),
                address.getPostCode());
    }

    public static Housing housingFromGrpc(GHousingWithStatus returnedHousing) {
        return new Housing(returnedHousing.getId(), returnedHousing.getCapacity(),
                addressFromGrpc(returnedHousing.getAddress()), returnedHousing.getAvailable());
    }

    public static GHousing housingToGrpc(Housing housing)
    {
        return  GHousing.newBuilder()
                .setId(housing.getHousingId())
                .setCapacity(housing.getCapacity())
                .setAddress(addressToGrpc(housing.getAddress()))
                .build();
    }

    public static GHousingWithStatus housingToGrpcWithStatus(Housing housing)
    {
        return  GHousingWithStatus.newBuilder()
                .setId(housing.getHousingId())
                .setCapacity(housing.getCapacity())
                .setAddress(addressToGrpc(housing.getAddress()))
                .setAvailable(housing.isAvailable())
                .build();
    }

    public static GDateOfBirth dateToGrpc(Date date)
    {
        return GDateOfBirth.newBuilder()
                .setDay(date.getDay())
                .setMonth(date.getMonth())
                .setYear(date.getYear()).build();
    }

    public static Date dateFromGrpc(GDateOfBirth date) {
        return new Date(date.getDay(), date.getMonth(), date.getYear());
    }

    public static GAddHousingRequest addHousingRequest(Housing housing, String email)
    {
        return GAddHousingRequest.newBuilder()
                .setHousing(housingToGrpc(housing))
                .setEmail(email).build();
    }

    public static Agreement agreementWithIdFromGrpc(GAgreement agreement) {
        return new Agreement(
                agreement.getId(),
                hostDetailsFromGrpc(agreement.getHostDetails()),
                housingFromGrpc(agreement.getHousing()),
                refugeeFromGrpc(agreement.getRefugee()),
                agreement.getStatus(),
                dateFromGrpc(agreement.getDateOfCreation()));
    }

    public static GAgreement agreementWithIdToGrpc(Agreement agreement) {

        LocalDate date = LocalDate.now();


        return GAgreement.newBuilder()
                .setId(agreement.getAgreementId())
                .setHostDetails(hostDetailsToGrpc(agreement.getHost()))
                .setHousing(housingToGrpcWithStatus(agreement.getHousing()))
                .setRefugee(refugeeToGrpc(agreement.getRefugee()))
                .setDateOfCreation(GDateOfBirth.newBuilder()
                        .setDay(date.getDayOfMonth())
                        .setMonth(date.getMonthValue())
                        .setYear(date.getYear())
                        .build()
                )
                .setStatus(agreement.isAccepted()).build();
    }

    public static GAgreement agreementToGrpc(Agreement agreement)
    {
        LocalDate date = LocalDate.now();

        return GAgreement.newBuilder()
                .setRefugee(refugeeToGrpc(agreement.getRefugee()))
                .setHostDetails(hostDetailsToGrpc(agreement.getHost()))
                .setHousing(housingToGrpcWithStatus(agreement.getHousing()))
                .setDateOfCreation(
                        GDateOfBirth.newBuilder()
                                .setDay(date.getDayOfMonth())
                                .setMonth(date.getMonthValue())
                                .setYear(date.getYear())
                                .build()
                )
                .setStatus(agreement.isAccepted()).build();
    }
}

