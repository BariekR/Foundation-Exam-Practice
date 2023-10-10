package generals;

import java.util.ArrayList;
import java.util.List;

public class Fight {
    private List<General> generals;

    public Fight(List<General> generals) {
        this.generals = generals;
    }

    public List<General> forTheEmpire() {
        List<General> output = new ArrayList<>();
        for (General general : generals) {
            if(general.getMotivationLevel() == 2 && general instanceof RomeEmpireGeneral) {
                output.add(general);
            }
        }
        return output;
    }
}
