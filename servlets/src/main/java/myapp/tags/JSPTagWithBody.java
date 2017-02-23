package myapp.tags;

import lombok.SneakyThrows;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class JSPTagWithBody extends BodyTagSupport {
    private int num;

    public void setNum(String num) {
        this.num = Integer.parseInt(num);
    }

    @Override
    @SneakyThrows
    public int doStartTag() throws JspTagException {
        pageContext.getOut().write("<table border=3 width=100%><tr><td>");
        return EVAL_BODY_INCLUDE;
    }

    @Override
    @SneakyThrows
    public int doAfterBody() throws JspTagException {
        if (--num > 0) {
            pageContext.getOut().write("</td></tr><tr><td>");
            return EVAL_BODY_AGAIN;
        } else
            return SKIP_BODY;
    }

    @Override
    @SneakyThrows
    public int doEndTag() throws JspTagException {
        pageContext.getOut().write("</td></tr></table>");
        return SKIP_BODY;
    }
}
