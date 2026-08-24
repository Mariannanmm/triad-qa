package org.web.pages;

import org.helpers.PageTools;

public class CompletePage extends PageTools {
    public static final CompletePage completePage=new CompletePage();
    private  CompletePage() {}

    private final String completeHeader = ".complete-header"; //css

    public String getCompleteHeader() {
        return getText("css", completeHeader);
    }
}
