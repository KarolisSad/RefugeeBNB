package via.sep3.group11.tier2.daoInterfaces;


public interface RefugeeDaoInterface {
    Refugee CreateRefugee(Refugee refugee) throws ValidationException;
    Refugee GetRefugeeByEmail(String email) throws ValidationException;
}
