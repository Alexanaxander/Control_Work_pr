package animals;

public abstract class animal {
    private String nameType;

    public animal(String nameType){
        this.nameType = nameType;
    }

    public animal() {
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

}
