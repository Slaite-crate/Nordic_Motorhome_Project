package nordic_motorhome_project.demo.models;

public class Modifier {
    private int modifierId;
    private String modifierName;
    private double modifier;

    public Modifier(int modifierId, String modifierName, double modifier) {
        this.modifierId = modifierId;
        this.modifierName = modifierName;
        this.modifier = modifier;
    }

    public Modifier(String modifierName, double modifier) {
        this.modifierName = modifierName;
        this.modifier = modifier;
    }

    public Modifier() {
    }

    public int getModifierId() {
        return modifierId;
    }

    public void setModifierId(int modifierId) {
        this.modifierId = modifierId;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public double getModifier() {
        return modifier;
    }

    public void setModifier(double modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "Modifier{" +
                "modifierId=" + modifierId +
                ", modifierName='" + modifierName + '\'' +
                ", modifier=" + modifier +
                '}';
    }
}
