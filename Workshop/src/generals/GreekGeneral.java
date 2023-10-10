package generals;

public class GreekGeneral extends General {
    public GreekGeneral(String name, int motivation) {
        super(name, motivation);
    }

    public GreekGeneral(String name) {
        super(name, 45);
    }

    @Override
    public void punch(General general) {
        if (!(general instanceof GreekGeneral)) {
            super.punch(general);
        }
    }

}
