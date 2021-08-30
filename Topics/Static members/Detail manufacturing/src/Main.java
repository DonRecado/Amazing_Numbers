class ManufacturingController {

    public static int productRequests = 0;

    public static String requestProduct(String product) {
        productRequests++;
        return productRequests + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return productRequests;
    }
}