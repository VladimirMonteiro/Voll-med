package med.voll.api.entities.enums;

public enum Specialty {
    ORTOPEDIA("ORTOPEDIA"),
    CARDIOLOGIA("CARDIOLOGIA"),
    GINECOLOGIA("GINECOLOGIA"),
    DERMATOLOGIA("DERMATOLOGIA");

    private String description;

    Specialty (String description) {
        this.description = description;
    }
}
