package View.ViewState.MainView;

import View.ViewState.StateListenable;

public class OptionsMainViewState extends StateListenable<OptionsMainViewState> {
    private Boolean onOpeningAfterOption = false;
    private Boolean onFilteringOption = false;

    public Boolean getOnOpeningAfterOption() {
        return onOpeningAfterOption;
    }

    public void setOnOpeningAfterOption(Boolean onOpeningAfterOption) {
        this.onOpeningAfterOption = onOpeningAfterOption;
        notifyStateListeners(this);
    }

    public Boolean getOnFilteringOption() {
        return onFilteringOption;
    }

    public void setOnFilteringOption(Boolean onFilteringOption) {
        this.onFilteringOption = onFilteringOption;
        notifyStateListeners(this);
    }
}
