import java.util.Objects;

public class Education extends PersonalInfo {

    private String level;
    private String institution;
    private Country country;
    private String city;

    public String getLevel() {
        return level;
    }

    public OperationResult setLevel(String level) {
        this.level = level;
        return new OperationResult(true, null);
    }

    public String getInstitution() {
        return institution;
    }

    public OperationResult setInstitution(String institution) {

        final String validInstitutionFormat = "[a-zA-Z-0-9 ]*";

        if (city.matches(validInstitutionFormat)) {
            this.institution = institution;
        } else {
            return new OperationResult(false, "Incorrect input format, should be "+validInstitutionFormat);
        }

        return new OperationResult(true, null);
    }

    public Country getCountry() {
        return country;
    }

    public OperationResult setCountry(Country country) {

        Country c = CountriesDictionary.getCountryByName(country.getName());

        if (Objects.nonNull(country) && Objects.nonNull(c)) {
            this.country = c;
        } else if (Objects.isNull(country)) {
            return new OperationResult(false, "Input object is null");
        } else {
            return new OperationResult(false, "No such country");
        }

        return new OperationResult(true, null);
    }

    public OperationResult setCountry(String countryName) {

        Country country = CountriesDictionary.getCountryByName(countryName);

        if (Objects.nonNull(country)) {
            this.country = country;
        } else {
            return new OperationResult(false, "No such country found "+countryName);
        }

        return new OperationResult(true, null);
    }

    public String getCity() {
        return city;
    }

    public OperationResult setCity(String city) {

        final String validCityFormat = "[a-zA-Z- ]*";

        if (city.matches(validCityFormat)) {
            this.city = city;
        } else {
            return new OperationResult(false, "Incorrect input format, should be "+validCityFormat);
        }

        return new OperationResult(true, null);
    }

    @Override
    public String getPersonInfoAsString() {
        return level + ", " + institution + ", from " + country + "/" + city;
    }

}
