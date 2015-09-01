package di.case2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerClz {
	@Autowired
	private ServiceClz serviceClz;

	public ServiceClz getServiceClz() {
		return serviceClz;
	}

}
