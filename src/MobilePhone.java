import java.util.Objects;

public class MobilePhone extends Contact {

    private String countryCode; //+7, +0, +1...
    private String msisdn; //7015657645

    public String getCountryCode() {
        return countryCode;
    }

    public OperationResult setCountryCode(String countryPhoneCode) throws OperationException{

        Country country = CountriesDictionary.getCountryByPhoneCode(countryPhoneCode);

        if (Objects.nonNull(country)) {
            this.countryCode = countryPhoneCode;
        } else {
            throw  new OperationException("Either no such phone code or database contains no code for that country");
        }

        return new OperationResult(true, null);
    }

    public String getMsisdn() {
        return msisdn;
    }

    public OperationResult setMsisdn(String msisdn) throws OperationException{
        if (msisdn.matches("\\d{10}")){
            this.msisdn = msisdn;
        }
        throw  new OperationException("Not correct msisdn");
    }

    @Override
    public String getContactAsString() {
        return getCountryCode() + " " + getMsisdn();
    }
}
