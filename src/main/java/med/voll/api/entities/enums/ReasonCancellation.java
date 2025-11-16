package med.voll.api.entities.enums;

public enum ReasonCancellation {
    PATIENT_GAVE_UP("PACIENTE DESISTIU"),
    DOCTOR_CANCEL("DOUTOR CANCELOU"),
    OTHERS("OUTROS");

    private String description;

    ReasonCancellation (String description) {
        this.description = description;
    }
}
