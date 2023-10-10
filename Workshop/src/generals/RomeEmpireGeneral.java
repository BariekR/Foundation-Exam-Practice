package generals;

public class RomeEmpireGeneral extends General {
    public RomeEmpireGeneral(String name, int motivation) {
        super(name, motivation);
    }

    public RomeEmpireGeneral(String name) {
        super(name, 45);
    }

    @Override
    public void punch(General general) {
        if (!(general instanceof RomeEmpireGeneral)) {
            super.punch(general);
        }
    }
}
