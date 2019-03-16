package wakandaforever.wakandaforever.validators;

import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.validators.base.Validator;

public class FarmObjectValidator implements Validator<FarmObject> {
    @Override
    public boolean isValid(FarmObject object) {
        return object != null &&
                isNameValid(object) &&
                isSecretIdentityValid(object);
    }

    private boolean isSecretIdentityValid(FarmObject object) {
//        return object.getSecretIdentity().length() >= Constants.SUPERHERO_SECRET_IDENTITY_MIN_LENGHT &&
//                object.getSecretIdentity().length() <= Constants.SUPERHERO_SECRET_IDENTITY_MAX_LENGHT;
        return true;
    }

    private boolean isNameValid(FarmObject object) {
//        return object.getName().length() >= Constants.SUPERHERO_NAME_MIN_LENGHT &&
//                object.getName().length() <= Constants.SUPERHERO_NAME_MAX_LENGHT;
        return true;
    }
}

