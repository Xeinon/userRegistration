package userSystem.core.concretes;

import userSystem.core.abstracts.AuthorizationService;
import userSystem.jExternalService.GoogleManager;

public class GoogleManagerAdapter extends BaseAuthorizationManager {

	@Override
	public void registerToSystem(String message) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.register(message);
		
	}

}
