package enums;

public enum EnumDropDownBootStrap {

    BOOTSTRAP_V3("Bootstrap V3 Theme"),
    BOOTSTRAP_V4("Bootstrap V4 Theme");


    private String boostraps;

    EnumDropDownBootStrap(String boostrap) {
        this.boostraps = boostrap;
    }

    public String getValues() {
        return boostraps;
    }
}
