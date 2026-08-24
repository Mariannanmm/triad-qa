package org.web.pages;

import org.helpers.PageTools;

public class ProductDetailPage extends PageTools {
    public static final ProductDetailPage productDetailPage = new ProductDetailPage();
    private ProductDetailPage() {}

    private final String detailName = ".inventory_details_name";   // css

    public String getName() {
        return getText("css",  detailName);
    }
}
