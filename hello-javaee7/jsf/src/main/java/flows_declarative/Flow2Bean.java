package flows_declarative;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped("flow2")
public class Flow2Bean implements Serializable {

    public String getName() {
        return this.getClass().getSimpleName();
    }
}