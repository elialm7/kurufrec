package KuroMoji;

public record IpadicToken(String surface,
                              String speechpart,
                              String baseform,
                              String conjugationForm,
                              String conjugationType,
                              String reading,
                              String pronunciation) {


    public static IpadicToken UndefinedToken(){
        return new IpadicToken(
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED"
        );
    }

}
