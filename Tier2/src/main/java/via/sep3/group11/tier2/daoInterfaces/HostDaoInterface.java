package via.sep3.group11.tier2.daoInterfaces;


public interface HostDaoInterface {
    Host CreateHost(Host host) throws ValidationException;
    Host GetHostByEmail(String email) throws ValidationException;
}
