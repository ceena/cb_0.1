package cb;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Cb_0_1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}