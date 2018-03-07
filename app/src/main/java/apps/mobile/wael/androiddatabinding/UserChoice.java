package apps.mobile.wael.androiddatabinding;

import android.databinding.BaseObservable;

/**
 * Created by wael on 07/03/18.
 */
public class UserChoice extends BaseObservable {
    private String userChoice;

    public UserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
        notifyPropertyChanged(BR.userChoice);
    }
}