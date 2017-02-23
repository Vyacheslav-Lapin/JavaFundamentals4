package myapp.tags;

import lombok.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Formatter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class SpecialJSPTag extends TagSupport {

    private JSPSetBean set;

    @Override
    @SneakyThrows
    public int doStartTag() throws JspException {
        int size = Integer.parseInt(set.getSize());

        printf("Size = <b>(%d)</b><table border=1>", size);
        for (int i = 0; i < size; i++)
            printf("<tr><td>%s</td></tr>", set.getElement());
        print("</table>");
        return SKIP_BODY;
    }

    @SneakyThrows
    private void print(String s) {
        pageContext.getOut().write(s);
    }

    private void printf(String pattern, Object... args) {
        print(new Formatter().format(pattern, args)
                        .toString());
    }
}
