public enum Typography {
    RESET("\033[0m"),

    BOLD("\033[1m"),

    BRIGHT_RED("\033[91m"),
    BRIGHT_GREEN("\033[92m"),
    BRIGHT_CYAN("\033[96m");

    private final String code;
    Typography(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}