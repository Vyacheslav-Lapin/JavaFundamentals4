package myapp.tags;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.Set;

public class JSPSetBean {
    private Iterator it;

    @Setter
    @Getter
    private Set<String> set;

    public JSPSetBean(Set<String> set) {
        this.set = set;
    }

    public String getSize(){
        it = set.iterator();
        return Integer.toString(set.size());
    }

    public String getElement(){
        return it.next().toString();
    }
}
